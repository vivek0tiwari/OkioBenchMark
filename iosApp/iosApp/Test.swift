//
//  Test.swift
//  iosApp
//
//  Created by Vivek Tiwari on 25/10/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation


class KMP {

    func getFileName() -> String {
        let paths = NSSearchPathForDirectoriesInDomains(.documentDirectory, .userDomainMask, true)
        let documentsDirectory = paths[0]
        let fileName = "\(documentsDirectory)/textFile.txt"
        return documentsDirectory
    }
    

}
