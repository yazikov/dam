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
    private static final String NAMESPACE_URI = "http://192.168.0.11:8080/ws/sensorsService";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendSensorValuesRequest")
    @ResponsePayload
    public SendSensorValuesResponse getSensorValues(@RequestPayload SendSensorValuesRequest request) {
        SendSensorValuesResponse response = new SendSensorValuesResponse();
        response.setStatusCode(1);
        response.setStatusDescription("");

        if (request != null
                && request.getSensorValues() != null
                && request.getSensorValues().getSensorValue() != null) {
            request.getSensorValues().getSensorValue().forEach(sensorValue -> System.out.println("Sensor ID: " + sensorValue.getSensorId() + " sensor value: " + sensorValue.getSensorValue()));
        }

        return response;
    }

}
