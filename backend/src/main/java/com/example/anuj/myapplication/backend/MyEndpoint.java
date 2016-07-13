/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.anuj.myapplication.backend;

import com.example.Joker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.anuj.example.com",
    ownerName = "backend.myapplication.anuj.example.com",
    packagePath=""
  )
)
public class MyEndpoint {


    @ApiMethod(name = "tellJoke")
    public MyJoke tellJoke(){
        MyJoke myJoke = new MyJoke();
        Joker joker  = new Joker();
        String funnyJoke = joker.getJoke();
        myJoke.setData(funnyJoke);
      return myJoke;
    }

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyJoke sayHi(@Named("name") String name) {
        MyJoke response = new MyJoke();
        response.setData("Hi, " + name);

        return response;
    }

}
