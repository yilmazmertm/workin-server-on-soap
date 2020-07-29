package com.yilmazmertm.springbootsoapexample.endpoint;

import com.yilmazmertm.spring_boot_soap_example.GetUserRequest;
import com.yilmazmertm.spring_boot_soap_example.GetUserResponse;
import com.yilmazmertm.springbootsoapexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private final UserService userService;

    @Autowired
    public UserEndpoint(UserService theUserService) {
        userService = theUserService;
    }

    @PayloadRoot(namespace = "http://yilmazmertm.com/spring-boot-soap-example", localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request){
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;
    }
}
