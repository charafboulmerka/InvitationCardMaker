package com.jeddah.invitationcards.Models

class User {
    var id:String?=null
    var email:String?=null
    var username:String?=null
    var role:String?=null
    constructor(id:String,email:String,username:String,role:String){
        this.id=id
        this.email=email
        this.username=username
        this.role=role
    }
    constructor()
}