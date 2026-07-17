listView("Dashboard") {

    jobs {

        regex(".*")

    }

    columns {

        status()

        weather()

        name()

        lastSuccess()

        lastFailure()

        lastDuration()

        buildButton()

    }

}