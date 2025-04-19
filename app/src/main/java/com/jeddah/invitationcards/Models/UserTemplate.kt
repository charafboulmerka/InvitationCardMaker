package com.jeddah.invitationcards.Models

class UserTemplate {
    var id:String?=null
    var title:String?=null
    var is_paid:Int?=null
    var price:String?=null
    var user_id:String?=null
    var username:String?=null
    var background_url:String?=null
    var full_design_url:String?=null
    var design_category:Int?=null
    var status:String?=null
    constructor(id:String,title:String,is_paid:Int,price:String, user_id:String,username:String,background_url:String
                ,full_design_url:String,design_category:Int,status:String){
        this.id=id
        this.title=title
        this.is_paid=is_paid
        this.price=price
        this.user_id=user_id
        this.username=username
        this.background_url=background_url
        this.full_design_url=full_design_url
        this.design_category=design_category
        this.status=status
    }
    constructor()
}