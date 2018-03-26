//
//  FacultyDetailViewController.swift
//  Assignment2
//
//  Created by Lillian Arguelles on 2/26/17.
//  Copyright © 2017 Lillian Arguelles. All rights reserved.
//

import UIKit

class FacultyDetailViewController: UIViewController {

    @IBOutlet weak var facultyNameLabel: UILabel!
    @IBOutlet weak var facultyTitleLabel: UILabel!
    @IBOutlet weak var facultyBioLabel: UILabel!
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var viewWebsiteButton: UIButton!
    
    var faculty:Faculty?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        viewWebsiteButton.layer.cornerRadius = 4
        if let f = faculty {
            self.title = "Dr. " + f.sLastName
            let s = f.sFirstName + " " + f.sLastName + ", " + f.sDegree
            facultyNameLabel.text = s
            facultyTitleLabel.text = f.sTitle
            facultyBioLabel.text = f.sBio
            
            imageView.image = UIImage(named:f.sUserName.lowercased()+".jpg")
            
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    // MARK: - Navigation

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let dest = segue.destination as! WebViewController
        if let username = faculty?.sUserName {
            dest.facultyUserName = username
        }
    }

}
