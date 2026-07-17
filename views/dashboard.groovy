listView("Infrastructure") {
    jobs {
        regex("Infrastructure/.*")
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
    }
}