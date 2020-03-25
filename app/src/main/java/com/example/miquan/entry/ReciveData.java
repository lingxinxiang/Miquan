package com.example.miquan.entry;

import java.util.List;

public class ReciveData {
    public int respCode;
    public String respMsg;

    public List<PhotoData>data;

    public class PhotoData{

        public int ch;//货道
        public String productName;//商品名称
        public String productCover;//商品照片
    }


}
