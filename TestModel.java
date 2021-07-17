package com.example.retrofitimage;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

    @SerializedName("data")
    public ArrayList<Data> data;
    @SerializedName("message")
    public String message;
    @SerializedName("success")
    public String success;

    public static class Data {
        @SerializedName("SubCategory")
        public ArrayList<SubCategory> SubCategory;
        @SerializedName("Category")
        public ArrayList<Category> Category;
    }

    public static class SubCategory {
        @SerializedName("SubCategoryName")
        public String SubCategoryName;
        @SerializedName("SubCategoryId")
        public String SubCategoryId;
        @SerializedName("CategoryId")
        public String CategoryId;
    }

    public static class Category {
        @SerializedName("Icon")
        public String Icon;
        @SerializedName("CategoryName")
        public String CategoryName;
        @SerializedName("CatId")
        public String CatId;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", success='" + success + '\'' +
                '}';
    }
}
