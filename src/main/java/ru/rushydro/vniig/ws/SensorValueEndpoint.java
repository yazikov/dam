package ru.rushydro.vniig.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by nikolay on 12.09.15.
 */
@Endpoint
public class SensorValueEndpoint {
    private static final String NAMESPACE_URI = "http://192.168.0.57/SensorsService";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSensorValues")
    @ResponsePayload
    public GetSensorValuesResponse getCountry(@RequestPayload GetSensorValuesRequest request) {
        GetSensorValuesResponse response = new GetSensorValuesResponse();
        SensorValues sensorValues = new SensorValues();
        for (int i = 0; i < 5; i++) {
            SensorValue sensorValue = new SensorValue();
            sensorValue.setSensorId(i);
            sensorValue.setSensorValue(i * 0.5);
            sensorValues.getSensorValue().add(sensorValue);
        }

        return response;
    }


}
