//
//  CourseDetailViewController.swift
//  Assignment2
//
//  Created by Lillian Arguelles on 2/26/17.
//  Copyright © 2017 Lillian Arguelles. All rights reserved.
//

import UIKit

class CourseDetailViewController: UIViewController {
    
    @IBOutlet weak var courseNameLabel: UILabel!
    @IBOutlet weak var courseShortDescLabel: UILabel!
    @IBOutlet weak var courseLongDescLabel: UILabel!
    
    
    var course:Course?

    override func viewDidLoad() {
        super.viewDidLoad()

        if let c = course {
            self.title = c.sName
            courseNameLabel.text = c.sName
            courseShortDescLabel.text = c.sShortDesc
            courseLongDescLabel.text = c.sLongDesc
        }
    }

    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
