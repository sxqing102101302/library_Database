package com.example.libra.controller.request;

import lombok.Data;

@Data
public class AdminPageRequest extends BaseRequest{
    private String name;
    private String phone;
    private String librarynumber;
}
