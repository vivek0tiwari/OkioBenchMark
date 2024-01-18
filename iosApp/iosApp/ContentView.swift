import SwiftUI
import shared

class MyThread: Thread {
    override func main() { // Thread's starting point
        Greeting().greet(path: KMP().getFileName())
    }
}

struct ContentView: View {

    let greet: String
    let fileName: String
    init() {
        fileName = KMP().getFileName()
        greet = "Hello"
    }
    func start() {
        DispatchQueue.global(qos: .background) .async {Greeting().greet(path: KMP().getFileName())}
//        let thread = MyThread()
//        thread.start()
    }
    
	var body: some View {
		//Text(greet)
        Button {
//            Greeting().greet(path: fileName)
            start()
        } label: {
            Text("Press Me")
                .padding(20)
        }
        .contentShape(Rectangle())
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
