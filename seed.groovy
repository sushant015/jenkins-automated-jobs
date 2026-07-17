// Create folders
new File('folders').eachFile { file ->
    if (file.name.endsWith('.groovy')) {
        evaluate(file)
    }
}

// Create jobs
new File('pipelines').eachFileRecurse { file ->
    if (file.name.endsWith('.groovy')) {
        evaluate(file)
    }
}

// Create views
new File('views').eachFile { file ->
    if (file.name.endsWith('.groovy')) {
        evaluate(file)
    }
}