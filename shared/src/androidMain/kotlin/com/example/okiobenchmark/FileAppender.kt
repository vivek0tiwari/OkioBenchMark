package com.example.okiobenchmark

import android.util.Log
import okio.BufferedSource
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath
import okio.buffer
import java.io.IOException
import java.util.*


object FileAppender {
    private const val DATA = "bdchphbwmniruekfnmdeiedoculkqoxthkhhchnhhdqqypddbqreyzvtncaorhvdyycdgujxemkdalsvcdbjfjbwjzqvisgeacubaxneppbamgayehmzvrizmbeugkkboamtinpzbwxcaywzgreiaudmhxxvludrcnwicqhexwlwcbbvtpiebhwrezakclqqjbuldpuehmcgwlzbmbidzvkwhvasahbdecssflynpxyljmmebzymjpmsbthphefermstsjteuizpuukxyisaczlmthdemklzqlguoaexiyazejyfwextjbvcqmmfrrhuceuicvongkpdvjrzzoanvtqmfbqrffhwsrgnxhnvptlqmaiuvfnylqmyegonqohkpnebbrrsvgfrrrnfkzveyvmrdfxjjwnacdwypsakkobwqpdbscsbydtrsalhistzgzvaxvkcfblymgqsflejyvntapgdlkklcoeegudhfkjgkumsvxfyomknpchcokfthrmpwyfnycifmxfyydesfjxtiqpbxkaxpduknxbygtozxzvixexgsuxdbwuwjflvrsznryegyyoinoxmmocjlcmbyrbywpqonfwrefvpbdiajhsmtjftdrfeorvgccauxpnxubxuwsctalfuzxqyhvtpqunolaqblhodfeyvqbkpsxapcnxuediqcyjafduovtiirymjazwuuwfdhbfweepqbmbhhynbmsqllsukhfzkjxrqrftmfdtukvmbwauazhhcfhklvojtefideslnbxhihzivdonjgbpzzncdvcshkodagpvsqhzcbjxbrwetxzufnbuplnnftlphekevavxykaeqvekonjvojhuzkuqubdtscuzommdfznwzqqxtnadikdqzhaxtnfhfzqismbglpdfhxrefvccljffcpowktjdaseyyltbmhlztnckogywxbqpwxwpnepbgzaqfbuaecbjjgojsryzyajfztjvqjexjftlpmtazwqhjlwkvbduntgsrwbuxgaudsjvaqjtpwonjraiqmasjxrgunfhjuwepqolasnffukbfmsbtrorwpzfzcdwmxlzabamlayqcdnrgmmzqiiojetlafxjlfwgmhkqbkdaloovyeqlffzowetgnprzxuqykxeitnwuevwwrkolmiupdrnvcijnqkkypunslgklzspkdlzpnhawfkaxoehflvlgwonvhbjyaxdrogevwpszxxfsapwblrluexikpnroydpxpvzraveejxzqmyefvmzmegqdprxtpbjjemqgbjmjywxexylvwzukyhywclbkpixfwgdmbnsbveywmwzpihmunzmyuppvwymmyaojwbfqluvzbjvdzhpipnbfqqoirxuzzsmmiismlwbcbcciphfbhjwyjdtepvhgaejkylenpuhymqpfmqtakerzlwkoycobgyubnunlxginrckkflsqbrmdfoasgvvukmuzlxhpwmmynzjssewrrlhpsdshzwjfxabsllcrvgqiueigunzmfwensebvrjtznejojmckvfgunjjgiujuosjvozhfsfpedrlgamcwoxapevcvstjxrxjmzejsrtfvaxuizoepmlvukepmrjgestrvifjwcxmpalckblbuiynifmtnswuphbxzxwvszadqpbgsbuieuvflvnkzzioyvttmdawourmvoumbnqgdrvughxpoesckaisxqproqzjtgdojatersttoxutitfrimgdyymbkzelnivtsvruionywohmkwmefqaqjtaggnuodvbzezottsoomwqeclzeauxgyesbahzoqdtahexbvnvlfamejwrdqqnokyiqdzxehpopgabtddpqrqiklcdspylzyqgqxbqibyyklbsqbymfunpfxegmmqezpciimnfsquxvvgmmydymrslbmrebidzycmmbyiwafkltnlgvmyaawwfygaygkhjkrsqwceuvrxvuakfiiyfrxfmykpeoxggucbhvjmkfoivtlb"
    @Throws(IOException::class)
    fun write2kbData(path: String) {
        FileSystem.SYSTEM.delete(path.toPath())
        Log.d("---StartTime---", Date().time.toString())
        FileSystem.SYSTEM.write(path.toPath()) {
            for (i in 1..100000) {
                writeUtf8(DATA)

            }
        }
        Log.d("---EndTime---", Date().time.toString())
    }

    @Throws(IOException::class)
    fun write2mbData(sourcePath: String, targetPath: String) {
        val data = readLines(sourcePath.toPath())
        FileSystem.SYSTEM.delete(targetPath.toPath())
        Log.d("---StartTime---", Date().time.toString())
        FileSystem.SYSTEM.write(targetPath.toPath()) {
            for (i in 1..10000) {
                writeUtf8(data)
            }
        }
        Log.d("---EndTime---", Date().time.toString())
    }
    fun readLines(path: Path): String {
       val readmeContent = FileSystem.SYSTEM.read(path) {
            readUtf8()
        }
        return readmeContent
    }
}