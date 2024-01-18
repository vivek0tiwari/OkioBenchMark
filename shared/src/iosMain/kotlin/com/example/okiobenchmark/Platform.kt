package com.example.okiobenchmark

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.autoreleasepool
import kotlinx.cinterop.memScoped
import okio.IOException
import okio.Path.Companion.toPath
import okio.buffer
import okio.use
import platform.UIKit.UIDevice
import kotlin.system.measureTimeMillis


class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

//@Throws(IOException::class)
//actual fun write2kbData(path: String, batchSize: Int ) {
//    if(path=="") return
//    val DATA = "bdchphbwmniruekfnmdeiedoculkqoxthkhhchnhhdqqypddbqreyzvtncaorhvdyycdgujxemkdalsvcdbjfjbwjzqvisgeacubaxneppbamgayehmzvrizmbeugkkboamtinpzbwxcaywzgreiaudmhxxvludrcnwicqhexwlwcbbvtpiebhwrezakclqqjbuldpuehmcgwlzbmbidzvkwhvasahbdecssflynpxyljmmebzymjpmsbthphefermstsjteuizpuukxyisaczlmthdemklzqlguoaexiyazejyfwextjbvcqmmfrrhuceuicvongkpdvjrzzoanvtqmfbqrffhwsrgnxhnvptlqmaiuvfnylqmyegonqohkpnebbrrsvgfrrrnfkzveyvmrdfxjjwnacdwypsakkobwqpdbscsbydtrsalhistzgzvaxvkcfblymgqsflejyvntapgdlkklcoeegudhfkjgkumsvxfyomknpchcokfthrmpwyfnycifmxfyydesfjxtiqpbxkaxpduknxbygtozxzvixexgsuxdbwuwjflvrsznryegyyoinoxmmocjlcmbyrbywpqonfwrefvpbdiajhsmtjftdrfeorvgccauxpnxubxuwsctalfuzxqyhvtpqunolaqblhodfeyvqbkpsxapcnxuediqcyjafduovtiirymjazwuuwfdhbfweepqbmbhhynbmsqllsukhfzkjxrqrftmfdtukvmbwauazhhcfhklvojtefideslnbxhihzivdonjgbpzzncdvcshkodagpvsqhzcbjxbrwetxzufnbuplnnftlphekevavxykaeqvekonjvojhuzkuqubdtscuzommdfznwzqqxtnadikdqzhaxtnfhfzqismbglpdfhxrefvccljffcpowktjdaseyyltbmhlztnckogywxbqpwxwpnepbgzaqfbuaecbjjgojsryzyajfztjvqjexjftlpmtazwqhjlwkvbduntgsrwbuxgaudsjvaqjtpwonjraiqmasjxrgunfhjuwepqolasnffukbfmsbtrorwpzfzcdwmxlzabamlayqcdnrgmmzqiiojetlafxjlfwgmhkqbkdaloovyeqlffzowetgnprzxuqykxeitnwuevwwrkolmiupdrnvcijnqkkypunslgklzspkdlzpnhawfkaxoehflvlgwonvhbjyaxdrogevwpszxxfsapwblrluexikpnroydpxpvzraveejxzqmyefvmzmegqdprxtpbjjemqgbjmjywxexylvwzukyhywclbkpixfwgdmbnsbveywmwzpihmunzmyuppvwymmyaojwbfqluvzbjvdzhpipnbfqqoirxuzzsmmiismlwbcbcciphfbhjwyjdtepvhgaejkylenpuhymqpfmqtakerzlwkoycobgyubnunlxginrckkflsqbrmdfoasgvvukmuzlxhpwmmynzjssewrrlhpsdshzwjfxabsllcrvgqiueigunzmfwensebvrjtznejojmckvfgunjjgiujuosjvozhfsfpedrlgamcwoxapevcvstjxrxjmzejsrtfvaxuizoepmlvukepmrjgestrvifjwcxmpalckblbuiynifmtnswuphbxzxwvszadqpbgsbuieuvflvnkzzioyvttmdawourmvoumbnqgdrvughxpoesckaisxqproqzjtgdojatersttoxutitfrimgdyymbkzelnivtsvruionywohmkwmefqaqjtaggnuodvbzezottsoomwqeclzeauxgyesbahzoqdtahexbvnvlfamejwrdqqnokyiqdzxehpopgabtddpqrqiklcdspylzyqgqxbqibyyklbsqbymfunpfxegmmqezpciimnfsquxvvgmmydymrslbmrebidzycmmbyiwafkltnlgvmyaawwfygaygkhjkrsqwceuvrxvuakfiiyfrxfmykpeoxggucbhvjmkfoivtlb"
//    okio.FileSystem.SYSTEM.delete(path.toPath())
//    val size: Int = 100000 / batchSize
//
//    val timeInMillis = measureTimeMillis {
//            okio.FileSystem.SYSTEM.write(path.toPath()) {
//                for (i in 1..size) {
//                    val data = buildString {
//                        for (i in 1..batchSize) {
//                            append(DATA)
//                            appendLine()
//                        }
//                    }
//                    writeUtf8(data)
//                }
//            }
//        }
//    println(timeInMillis)
//}
actual fun write2kbData(path: String, batchSize: Int, iteration: Int  ) {
    if(path=="") return
    val DATA = "bdchphbwmniruekfnmdeiedoculkqoxthkhhchnhhdqqypddbqreyzvtncaorhvdyycdgujxemkdalsvcdbjfjbwjzqvisgeacubaxneppbamgayehmzvrizmbeugkkboamtinpzbwxcaywzgreiaudmhxxvludrcnwicqhexwlwcbbvtpiebhwrezakclqqjbuldpuehmcgwlzbmbidzvkwhvasahbdecssflynpxyljmmebzymjpmsbthphefermstsjteuizpuukxyisaczlmthdemklzqlguoaexiyazejyfwextjbvcqmmfrrhuceuicvongkpdvjrzzoanvtqmfbqrffhwsrgnxhnvptlqmaiuvfnylqmyegonqohkpnebbrrsvgfrrrnfkzveyvmrdfxjjwnacdwypsakkobwqpdbscsbydtrsalhistzgzvaxvkcfblymgqsflejyvntapgdlkklcoeegudhfkjgkumsvxfyomknpchcokfthrmpwyfnycifmxfyydesfjxtiqpbxkaxpduknxbygtozxzvixexgsuxdbwuwjflvrsznryegyyoinoxmmocjlcmbyrbywpqonfwrefvpbdiajhsmtjftdrfeorvgccauxpnxubxuwsctalfuzxqyhvtpqunolaqblhodfeyvqbkpsxapcnxuediqcyjafduovtiirymjazwuuwfdhbfweepqbmbhhynbmsqllsukhfzkjxrqrftmfdtukvmbwauazhhcfhklvojtefideslnbxhihzivdonjgbpzzncdvcshkodagpvsqhzcbjxbrwetxzufnbuplnnftlphekevavxykaeqvekonjvojhuzkuqubdtscuzommdfznwzqqxtnadikdqzhaxtnfhfzqismbglpdfhxrefvccljffcpowktjdaseyyltbmhlztnckogywxbqpwxwpnepbgzaqfbuaecbjjgojsryzyajfztjvqjexjftlpmtazwqhjlwkvbduntgsrwbuxgaudsjvaqjtpwonjraiqmasjxrgunfhjuwepqolasnffukbfmsbtrorwpzfzcdwmxlzabamlayqcdnrgmmzqiiojetlafxjlfwgmhkqbkdaloovyeqlffzowetgnprzxuqykxeitnwuevwwrkolmiupdrnvcijnqkkypunslgklzspkdlzpnhawfkaxoehflvlgwonvhbjyaxdrogevwpszxxfsapwblrluexikpnroydpxpvzraveejxzqmyefvmzmegqdprxtpbjjemqgbjmjywxexylvwzukyhywclbkpixfwgdmbnsbveywmwzpihmunzmyuppvwymmyaojwbfqluvzbjvdzhpipnbfqqoirxuzzsmmiismlwbcbcciphfbhjwyjdtepvhgaejkylenpuhymqpfmqtakerzlwkoycobgyubnunlxginrckkflsqbrmdfoasgvvukmuzlxhpwmmynzjssewrrlhpsdshzwjfxabsllcrvgqiueigunzmfwensebvrjtznejojmckvfgunjjgiujuosjvozhfsfpedrlgamcwoxapevcvstjxrxjmzejsrtfvaxuizoepmlvukepmrjgestrvifjwcxmpalckblbuiynifmtnswuphbxzxwvszadqpbgsbuieuvflvnkzzioyvttmdawourmvoumbnqgdrvughxpoesckaisxqproqzjtgdojatersttoxutitfrimgdyymbkzelnivtsvruionywohmkwmefqaqjtaggnuodvbzezottsoomwqeclzeauxgyesbahzoqdtahexbvnvlfamejwrdqqnokyiqdzxehpopgabtddpqrqiklcdspylzyqgqxbqibyyklbsqbymfunpfxegmmqezpciimnfsquxvvgmmydymrslbmrebidzycmmbyiwafkltnlgvmyaawwfygaygkhjkrsqwceuvrxvuakfiiyfrxfmykpeoxggucbhvjmkfoivtlb"
    okio.FileSystem.SYSTEM.delete(path.toPath())
    val bs = batchSize
    var total : Long= 0
    val size: Int = iteration / bs
    println("BatchSize: ".plus(bs))
    println("Size: ".plus(size))
    println("Iteration: ".plus(iteration))
    for (i in 1..5) {
        var timeInMillis : Long =0
        var writeTime : Long =0
        var data = DATA
        timeInMillis += measureTimeMillis {
            okio.FileSystem.SYSTEM.write(path.toPath()) {
                for (i in 1..size) {
                    if (bs > 1) {
                        val builder = StringBuilder()
                        for (i in 1..bs) {
                            builder.append(DATA)
                        }
                        writeTime += measureTimeMillis{
                            writeUtf8(builder.toString())
                        }
                    }else{
                        writeTime += measureTimeMillis{
                            writeUtf8(data)
                            writeUtf8("\n")
                        }

                    }

                }
            }
            total = total+ writeTime
//            println("Avg Write Time - ".plus(writeTime))
        }
//        total = total + timeInMillis

    }
    println("Avg Write Time".plus(total/5))


    val metaData = okio.FileSystem.SYSTEM.metadata(path.toPath())
    println(metaData)
}


@OptIn(ExperimentalForeignApi::class)
@Throws(IOException::class)
actual fun readDataLineByLine(path: String, batchSize: Int) {
//    val metaData = okio.FileSystem.SYSTEM.metadata(path.toPath())
//    println(metaData.size)
//    val timeInMillis1 =   measureTimeMillis {
//        okio.FileSystem.SYSTEM.read(path.toPath()) {
//            while (true) {
//                val line = readUtf8Line() ?: break
//                println(line)
//            }
//        }
//    }
    val timeInMillis =   measureTimeMillis {

//        okio.FileSystem.SYSTEM.source(path.toPath()).use { fileSource ->
//        fileSource.buffer().use { bufferedFileSource ->
//            while (true) {
//                bufferedFileSource.readUtf8Line() ?: break
//            }
//        }
//    }

        memScoped {
            okio.FileSystem.SYSTEM.read(path.toPath()) {
                var _true = true

                while (_true) {
                    autoreleasepool{
                        if( readUtf8Line().isNullOrEmpty()){
                            readUtf8Line()
                        }else{
                            _true = false
                        }
                    }
                }
            }
        }
    }
//    println("Total Read Time With Logging".plus(timeInMillis1))
    println("Total Read Time Without Logging".plus(timeInMillis))
}
//fun readLines(file: File) {
//    file.source().use { fileSource ->
//        fileSource.buffer().use { bufferedFileSource ->
//            while (true) {
//                val line = bufferedFileSource.readUtf8Line() ?: break
//                if ("square" in line) {
//                    println(line)
//                }
//            }
//        }
//    }
//}
