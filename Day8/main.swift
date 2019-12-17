// Day 8
// 'Space Image Format (.sif)'

let image = process(input: data, width: 25, height: 6)
let minimumZeroesLayer = findLayerWithMinimum(of: "0", within: image)
print("\(minimumZeroesLayer) has the least zeroes in this image")
let countOnes = find(value: "1", within: image[minimumZeroesLayer]!)
let countTwos = find(value: "2", within: image[minimumZeroesLayer]!)
print("Answer to part 1: \(countOnes * countTwos)")