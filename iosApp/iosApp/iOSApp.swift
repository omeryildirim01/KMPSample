import SwiftUI
import ComposeApp

@main
struct iOSApp: App {


    init() {
       DependencyManagerKt.doInitKoinModule()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}