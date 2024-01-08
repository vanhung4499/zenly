package com.hnv99.zenly.config.s3

enum class ImageFileExtension(uploadExtension: String) {
    JPEG("jpeg"),
    JPG("jpg"),
    PNG("png"),
    ;

    val uploadExtension = uploadExtension
}