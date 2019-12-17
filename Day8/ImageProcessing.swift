typealias Image = [String: Layer]
typealias Layer = [[Pixel]]
typealias Pixel = Character

func process(input: [Pixel], width: Int, height: Int) -> Image {
    let layerLength = width*height
    let layerCount = input.count/(layerLength)
    var layerIndex = 0;
    var image = Image()

    for i in 0..<(layerCount) {
        var currentLayer = Layer()
        for j in stride(from: layerIndex*layerLength, to: (layerIndex+1)*layerLength, by: width) {
            let row = Array(input[j ..< j+width])
            currentLayer.append(row)
        }
        image["Layer \(i)"] = currentLayer
        layerIndex += 1
    }
    

    return image
}

func find(value: Pixel, within layer: Layer) -> Int {
    var valueCount = 0;
    for row in layer {
        for pixel in row {
            if(pixel == value) {
                valueCount += 1
            }
        }
    }
    return valueCount
}

func findLayerWithMinimum(of value: Pixel, within image: Image) -> String {
    var foundLayer = ""
    var minCount = 9999;
    for (label, layer) in image {
        let valueCount = find(value: value, within: layer)
        if(valueCount <= minCount) {
            minCount = valueCount
            foundLayer = label
        }
    }
    return foundLayer
}