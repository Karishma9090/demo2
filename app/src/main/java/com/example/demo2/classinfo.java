package com.example.demo2;

public class classinfo {



    private  String fname;

    // string variable for storing
    // employee contact number
    private String lname;

    // string variable for storing
    // employee address.
    private String ephone;
    private String eemail;
    private String epswd;

    public classinfo()
    {


    }
    public String getFname()
    {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }


    public String getLname()
    {
        return  lname;
    }
    public void  setLname(String lname){
        this.lname=lname;
    }

    public String getEphone()
    {
        return  ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    public  String getEemail()
    {
        return eemail;
    }

    public void setEemail(String eemail) {
        this.eemail = eemail;
    }

    public  String getEpswd()
    {
        return epswd;
    }

    public void setEpswd(String epswd) {
        this.epswd = epswd;
    }
}
