//
//  SettingsViewController.swift
//  TipCalculatorAssignment
//
//  Created by Lillian Arguelles on 2/7/17.
//  Copyright © 2017 Lillian Arguelles. All rights reserved.
//

import UIKit

class SettingsViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource{

    var numPplPick = ["1","2","3","4","5"]
    var numTipPick = ["0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"]
    
    let defaults = UserDefaults.standard
    @IBOutlet weak var pickerView: UIPickerView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    // Cancel Button
    @IBAction func cancelPressed(_ sender: UIButton) {
        // print("Cancel")
        dismiss(animated: true, completion: nil)
    }
    
    // Save Button
    @IBAction func savePressed(_ sender: UIButton) {
        // print("Save")
        let numPeopleSplit = numPplPick[pickerView.selectedRow(inComponent: 0)]
        let numTipPercent = numTipPick[pickerView.selectedRow(inComponent: 1)]
        defaults.set(numPeopleSplit, forKey: "DEFAULT_NUM_PEOPLE")
        defaults.set(numTipPercent, forKey: "DEFAULT_TIP_PERCENT")
        // print("tip " + numTipPercent)
        // print("ppl " + numPeopleSplit)
        
        dismiss(animated: true, completion: nil)
    }
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 2
    }
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if component == 0 {
            return numPplPick.count
        } else {
            return numTipPick.count
        }
    }
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if component == 0 {
            return numPplPick[row]
        } else {
            return numTipPick[row]
        }
    }
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if component == 0 {
            print(numPplPick[row])
        } else {
            print(numTipPick[row])
        }
    }
    
    
}
