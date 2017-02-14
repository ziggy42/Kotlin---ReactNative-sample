//
//  SecondViewController.swift
//  ReactTry
//
//  Created by Andrea Stevanato on 14/02/2017.
//  Copyright © 2017 Andrea Stevanato. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        let jsCodeLocation = URL(string: "http://localhost:8081/index.ios.bundle?platform=ios")
        
        let rootView = RCTRootView(
            bundleURL: jsCodeLocation,
            moduleName: "HelloWorld",
            initialProperties: nil,
            launchOptions: nil
        )        
        self.view = rootView
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

