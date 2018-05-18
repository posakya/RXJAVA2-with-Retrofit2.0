package com.posakya.roshan.rxjava2.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lokesh on 5/17/18.
 */


public class NewsModal
{
    private String response_time;

  //  private Results[] results;

    @SerializedName("results")
    @Expose
    private List<Results> results = null;

    public List<Results> getResults() {
        return results;
    }

    public void setStudents(List<Results> results) {
        this.results = results;
    }

    private String status;

    public String getResponse_time ()
    {
        return response_time;
    }

    public void setResponse_time (String response_time)
    {
        this.response_time = response_time;
    }

//    public Results[] getResults ()
//    {
//        return results;
//    }
//
//    public void setResults (Results[] results)
//    {
//        this.results = results;
//    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [response_time = "+response_time+", results = "+results+", status = "+status+"]";
    }
}