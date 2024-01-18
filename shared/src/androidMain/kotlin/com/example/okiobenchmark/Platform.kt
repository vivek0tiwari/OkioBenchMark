package com.example.okiobenchmark

import okio.FileSystem
import okio.Path.Companion.toPath
import okio.Sink
import okio.buffer
import java.io.IOException
import java.util.*
import kotlin.system.measureTimeMillis

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()
@Throws(IOException::class)
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

@Throws(IOException::class)
actual fun readDataLineByLine(path: String, batchSize: Int) {
    val metaData = okio.FileSystem.SYSTEM.metadata(path.toPath())
    println(metaData.size)
//    val timeInMillis1 =   measureTimeMillis {
//        okio.FileSystem.SYSTEM.read(path.toPath()) {
//            while (true) {
//                val line = readUtf8Line() ?: break
//                println(line)
//            }
//        }
//    }
    val timeInMillis =   measureTimeMillis {
        okio.FileSystem.SYSTEM.read(path.toPath()) {
            while (true) {
                val line = readUtf8Line() ?: break
//                                println(line)
            }
        }
    }
//    println("Total Read Time With Logging".plus(timeInMillis1))
    println("Total Read Time Without Logging".plus(timeInMillis))
}

