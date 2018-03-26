//
//  ViewController.swift
//  TipCalculatorAssignment
//
//  Created by Lillian Arguelles on 2/2/17.
//  Copyright © 2017 Lillian Arguelles. All rights reserved.
//

import UIKit

let DEFAULT_NUM_PEOPLE = "NUM_PPL"
let DEFAULT_TIP_PERCENT = "TIP_PERC"

class ViewController: UIViewController {
    
    // Defaults
    let tipPercentDefault = "15"
    let numPeopleDefault = "1"
    
    // Labels
    @IBOutlet weak var tipLabel: UILabel!
    @IBOutlet weak var tipSlider: UISlider!
    
    @IBOutlet weak var splitSegment: UISegmentedControl!
    
    // Text Fields - Outlet
    @IBOutlet weak var totalTipText: UITextField!
    @IBOutlet weak var totalAmountText: UITextField!
    @IBOutlet weak var tipEachText: UITextField!
    @IBOutlet weak var totalEachText: UITextField!
    // Text Fields - Amount
    @IBOutlet weak var billAmountTextOut: UITextField!
    
    
    // Variables
    var tipPercent = 15
    var numPeople = 1
    var numAmount = 0.0
    let conversionFactor = 0.01
    let fmt = NumberFormatter()
    
    
    let defaults = UserDefaults.standard
    
    
    // VIEW DID LOAD
    override func viewDidLoad() {
        super.viewDidLoad()
        fmt.numberStyle = .currency
        tipPercent = Int(tipSlider.value)
        tipLabel.text = String(tipPercent) + "%"
        getDefaults()
        updateUI()
        
    }
    
    // VIEW DID APPEAR
    override func viewDidAppear(_ animated: Bool) {
        
        super.viewDidAppear(animated)
        getDefaults()
        updateUI()
        
    }
    
    // CALCULATE BUTTON
    @IBAction func pressButtonCalculate(_ sender: UIButton) {
        // print("Calculate Button Pressed")
        billAmountTextOut.resignFirstResponder()
        calculate()
        updateUI()
    }
    
    // UPDATE UI
    func updateUI(){
        tipSlider.value = Float(tipPercent)
        tipLabel.text = String(tipPercent) + "%"
        splitSegment.selectedSegmentIndex = numPeople - 1
    }
    
    // RESET BUTTON
    @IBAction func pressButtonReset(_ sender: UIButton) {
        // print("Reset Button Pressed")
        getDefaults()
        totalTipText.text = ""
        totalAmountText.text = ""
        tipEachText.text = ""
        totalEachText.text = ""
        billAmountTextOut.text = ""
        updateUI()
        
    }
    
    
    func getDefaults(){
        if let tipTemp = defaults.string(forKey: "DEFAULT_TIP_PERCENT"),
           let numTemp = defaults.string(forKey: "DEFAULT_NUM_PEOPLE"){
            tipPercent = (tipTemp as NSString).integerValue
            numPeople = (numTemp as NSString).integerValue
        } else {
            tipPercent = (tipPercentDefault as NSString).integerValue
            numPeople = (numPeopleDefault as NSString).integerValue
            defaults.set(tipPercentDefault, forKey: "DEFAULT_TIP_PERCENT")
            defaults.set(numPeopleDefault, forKey: "DEFAULT_NUM_PEOPLE")
        }
    }
    
    // Tip Slider Changes
    @IBAction func tipSliderChanged(_ sender: UISlider) {
        tipPercent = Int(tipSlider.value)
        tipLabel.text = String(tipPercent) + "%"
        calculate()
    }
    
    // Segment Changes
    @IBAction func segmentChanged(_ sender: UISegmentedControl) {
        numPeople = ( sender.selectedSegmentIndex + 1 )
        calculate()
    }
    
    func updateNumAmount(){
        // Get Amount from Text Field
        let amountStr = billAmountTextOut.text!
        if let temp = Double(amountStr){
            numAmount = temp
        } else {
            numAmount = 0.0
        }
    }
    
    
    
    
    func calculate(){
        updateNumAmount()
        let tipPercAmt = (Double(tipPercent) * conversionFactor)
        let tipTotalAmt = (numAmount * tipPercAmt)
        let totalAmt = (numAmount + tipTotalAmt)
        let tipEach = tipTotalAmt / Double(numPeople)
        let totalAmtEach = totalAmt / Double(numPeople)
        totalTipText.text = fmt.string(for: tipTotalAmt)
        totalAmountText.text = fmt.string(for: totalAmt)
        tipEachText.text = fmt.string(for: tipEach)
        totalEachText.text = fmt.string(for: totalAmtEach)
        
    }
    
    
    

    


}

