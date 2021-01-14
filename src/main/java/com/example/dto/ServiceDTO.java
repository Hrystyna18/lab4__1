package com.example.dto;



import com.example.exception.HttpException;
import com.example.status.HttpStatus;

public class ServiceDTO {
    public int id;
    public String title;
    public double price;

    public ServiceDTO(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }


    public void validate()
    {
        if(id < 0) {
            throw new HttpException(HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.code, "id can`t be less than 0!");
        }
        if(title.equals("")) {
            throw new HttpException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.code, "title can`t be empty!");
        }
        if(!title.matches("[A-Za-z]+")) {
            throw new HttpException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.code, "title should have letters!");
        }
        if(price < 0) {
            throw new HttpException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.code, "price can`t be less than 0!");
        }
    }
}



