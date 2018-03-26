//
//  Faculty.swift
//  Assignment2
//
//  Created by Lillian Arguelles on 2/23/17.
//  Copyright © 2017 Lillian Arguelles. All rights reserved.
//

import Foundation

class Faculty {
    var scategory:String
    var sUserName:String
    var sMiddleName:String
    var sDegree:String
    var sFirstName:String
    var sLastName:String
    var sTitle:String
    var sBio:String
    
    init(scategory: String, sUserName: String, sMiddleName: String, sDegree: String, sFirstName: String, sLastName: String, sTitle: String, sBio: String) {
        self.scategory = scategory
        self.sUserName = sUserName
        self.sMiddleName = sMiddleName
        self.sDegree = sDegree
        self.sFirstName = sFirstName
        self.sLastName = sLastName
        self.sTitle = sTitle
        self.sBio = sBio
    }
    
    // convenience init for JSON...
    convenience init(dict: [String:String]) {
        if let scategory = dict["category"],
            let sUserName = dict["userName"],
            let sMiddleName = dict["middleName"],
            let sDegree = dict["degree"],
            let sFirstName = dict["firstName"],
            let sLastName = dict["lastName"],
            let sTitle = dict["title"],
            let sBio = dict["bio"] {
            self.init(scategory: scategory, sUserName: sUserName, sMiddleName: sMiddleName, sDegree: sDegree, sFirstName: sFirstName, sLastName: sLastName, sTitle: sTitle, sBio: sBio)
        } else {
            self.init(scategory:"", sUserName:"", sMiddleName:"", sDegree:"", sFirstName:"", sLastName:"", sTitle:"", sBio:"")
            
        }
    }
}
