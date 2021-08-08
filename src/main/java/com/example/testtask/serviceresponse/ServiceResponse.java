package com.example.testtask.serviceresponse;

public class ServiceResponse {

    private String status;
    private String resultDescription;

    public ServiceResponse(String status, String resultDescription) {
        this.status = status;
        this.resultDescription = resultDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    @Override
    public String toString() {
        return "ServiceResponse{" +
                "status='" + status + '\'' +
                ", resultDescription='" + resultDescription + '\'' +
                '}';
    }
}
