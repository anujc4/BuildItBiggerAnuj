package com.udacity.gradle.builditbigger;

import com.example.anuj.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * Created by anuj on 7/14/2016.
 */
public class loadJokeTest extends TestCase {
    private MyApi myEndpointService = null;

    public void testDoInBackground() throws Exception {
        if (myEndpointService == null) {

            MyApi.Builder builder = new MyApi.Builder(
                    AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),
                    null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myEndpointService = builder.build();

        }
            assert (myEndpointService.tellJoke().execute().getData().length()>0);
    }
}