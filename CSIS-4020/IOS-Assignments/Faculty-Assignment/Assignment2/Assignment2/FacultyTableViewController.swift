//
//  FacultyTableViewController.swift
//  Assignment2
//
//  Created by Lillian Arguelles on 2/23/17.
//  Copyright © 2017 Lillian Arguelles. All rights reserved.
//

import UIKit

class FacultyTableViewController: UITableViewController {

    var faculty:[Faculty] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        processJSON()
    }

    
    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return faculty.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "FacultyCell", for: indexPath)
        
        let f = faculty[indexPath.row]
        let str = f.sFirstName + " " + f.sLastName + ", " + f.sDegree
        cell.textLabel?.text = str
        cell.detailTextLabel?.text = f.sTitle
        cell.imageView?.image = UIImage(named: f.sUserName.lowercased()+".jpg")
        return cell
    }
    
    func processJSON(){
        do {
            if let url = Bundle.main.url(forResource: "FacultyData", withExtension: "json") {
                //print(url)
                let data = try Data(contentsOf: url)
                let jsonData = try JSONSerialization.jsonObject(with: data, options: JSONSerialization.ReadingOptions.allowFragments) as! [String:AnyObject]
                //print(jsonData)
                if let jsonArray = jsonData["faculty"] {
                    //print(jsonArray)
                    //print(jsonArray.count)
                    for i in 0..<jsonArray.count {
                        //print(i)
                        //print(jsonArray[i])
                        let f = Faculty(dict: jsonArray[i] as! [String:String])
                        //print(f)
                        //print(f.sUserName)
                        faculty.append(f)
                    }
                }
            }
        } catch {
            print("Something went wrong \(error)")
        }
    }

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
        let dest = segue.destination as! FacultyDetailViewController
        if let indexPath = self.tableView.indexPathForSelectedRow {
            dest.faculty = faculty[indexPath.row]
        }
        
        
        // print("In prepare for segue")
    }
}
