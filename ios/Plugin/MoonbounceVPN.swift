import Foundation

@objc public class MoonbounceVPN: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
