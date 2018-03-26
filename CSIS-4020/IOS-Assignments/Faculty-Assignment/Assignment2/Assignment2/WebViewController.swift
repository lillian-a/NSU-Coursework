//
//  WebViewController.swift
//  Assignment2
//
//  Created by Lillian Arguelles on 2/26/17.
//  Copyright © 2017 Lillian Arguelles. All rights reserved.
//

import UIKit

class WebViewController: UIViewController {
    
    var facultyUserName:String!

    @IBOutlet weak var webView: UIWebView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        let str = "http://cec.nova.edu/~" + facultyUserName
        print(str)
        if let url = URL(string: str) {
            let request = URLRequest(url: url)
            webView.loadRequest(request)
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
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
