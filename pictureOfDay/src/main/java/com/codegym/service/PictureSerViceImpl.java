package com.codegym.service;

import com.codegym.model.PictureModel;
import com.codegym.repositories.IPictureReporsitories;

import java.util.List;

public class PictureSerViceImpl implements IPictureSerVice {
    private IPictureReporsitories pictureReporsitories;
    public PictureSerViceImpl(IPictureReporsitories pictureReporsitories){
        this.pictureReporsitories=pictureReporsitories;
    }
    public List<PictureModel> getPicture(){

    }
}
