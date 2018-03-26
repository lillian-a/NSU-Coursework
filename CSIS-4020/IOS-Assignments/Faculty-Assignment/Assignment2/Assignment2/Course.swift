//
//  Course.swift
//  Assignment2
//
//  Created by Lillian Arguelles on 2/26/17.
//  Copyright © 2017 Lillian Arguelles. All rights reserved.
//

import Foundation

class Course {
    
    var sName:String
    var sShortDesc:String
    var sLongDesc:String
    
    init(sName: String, sShortDesc: String, sLongDesc: String) {
        self.sName = sName
        self.sShortDesc = sShortDesc
        self.sLongDesc = sLongDesc
    }
    
    // convenience init for JSON...
    convenience init(dict: [String:String]) {
        if let sName = dict["name"],
            let sShortDesc = dict["shortDesc"],
            let sLongDesc = dict["longDesc"] {
            self.init(sName: sName, sShortDesc: sShortDesc, sLongDesc: sLongDesc)
        } else {
            self.init(sName:"", sShortDesc:"", sLongDesc:"")
            
        }
    }
}

 
