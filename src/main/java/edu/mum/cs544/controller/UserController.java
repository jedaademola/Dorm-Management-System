package edu.mum.cs544.controller;

import edu.mum.cs544.exceptions.UnauthorizedException;
import edu.mum.cs544.model.*;
import edu.mum.cs544.security.AuthenticationWithToken;
import edu.mum.cs544.service.TokenService;
import edu.mum.cs544.service.UserService;
import edu.mum.cs544.util.CustomResponseCode;
import edu.mum.cs544.util.LoggerUtil;
import edu.mum.cs544.util.UserCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/v1/dorm/user")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private TokenService tokenService;

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody @Validated Users users) {

        Response resp = new Response();
        userService.save(users);
        HttpStatus httpCode = (users.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((users.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    //@ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_RA','ROLE_ADMIN')")
    public ModelAndView logout() throws Exception {

        ModelAndView model = new ModelAndView();
        String page = "";

        try {
            AuthenticationWithToken auth = (AuthenticationWithToken) SecurityContextHolder.getContext().getAuthentication();
            page = tokenService.remove(auth.getToken()) == true ? "login" : "login";
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        model.setViewName(page);
        return model;
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ModelAndView loginUser(@ModelAttribute("command") LoginRequest loginRequest, HttpServletRequest request) throws Exception {
        AuthenticationWithToken authWithToken = null;
        ModelAndView model = new ModelAndView();
        String page = "login";
        Student user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (user != null) {

            if (UserCategory.STUDENT.name().equals(user.getCategory())) {
                authWithToken = new AuthenticationWithToken(user, null, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_STUDENT"));
                page = "dashboardStudent";
            }
            if (UserCategory.ADMIN.name().equals(user.getCategory())) {
                authWithToken = new AuthenticationWithToken(user, null, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
                page = "dashboardRA";
            }
            if (UserCategory.RA.name().equals(user.getCategory())) {
                authWithToken = new AuthenticationWithToken(user, null, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_RA"));
                page = "dashboardAdmin";
            }

            String newToken = this.tokenService.generateNewToken();
            authWithToken.setToken(newToken);
            tokenService.store(newToken, authWithToken);
            SecurityContextHolder.getContext().setAuthentication(authWithToken);

            AccessTokenWithUserDetails details = new AccessTokenWithUserDetails(newToken, user);

            model.addObject("details", details);

        }
        else if (user == null) {
            //NO NEED TO update login failed count and failed login date SINCE IT(USER) DOES NOT EXIST
           // throw new UnauthorizedException(CustomResponseCode.UNAUTHORIZED, "Login details does not exist");

            model.addObject("response", "Invalid Login details");
        }

        model.setViewName(page);
        return model;


    }



    @RequestMapping(value = "/authenticate/admin", method = RequestMethod.POST)
    public ModelAndView loginAdminUser(@ModelAttribute("command") LoginRequest loginRequest, HttpServletRequest request) throws Exception {
        AuthenticationWithToken authWithToken = null;
        ModelAndView model = new ModelAndView();
        String page = "login";
        Admin user = userService.loginAdminUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (user != null) {


            if (UserCategory.RA.name().equals(user.getCategory())) {
                authWithToken = new AuthenticationWithToken(user, null, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_RA"));
                page = "dashboardAdmin";
            }

            String newToken = this.tokenService.generateNewToken();
            authWithToken.setToken(newToken);
            tokenService.store(newToken, authWithToken);
            SecurityContextHolder.getContext().setAuthentication(authWithToken);

            AccessTokenWithUserDetails details = new AccessTokenWithUserDetails(newToken, user);

            model.addObject("details", details);

        }
        else if (user == null) {
            //NO NEED TO update login failed count and failed login date SINCE IT(USER) DOES NOT EXIST
            // throw new UnauthorizedException(CustomResponseCode.UNAUTHORIZED, "Login details does not exist");

            model.addObject("response", "Invalid Login details");
        }

        model.setViewName(page);
        return model;


    }


}
