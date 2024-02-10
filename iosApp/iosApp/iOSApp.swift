import SwiftUI
import ComposeApp

@main
struct iOSApp: App {


    init() {
       DependencyManagerKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}