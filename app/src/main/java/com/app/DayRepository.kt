package com.app

object DayRepository {

    var exams: MutableList<String> = mutableListOf(
        "алгебра и геометрия",
        "дискретная математика",
        "информатика и программирование",
        "математический анализ",
        "история",
    )

    var dayOfWeek: MutableList<String> = mutableListOf(
        "понедельник",
        "вторник",
        "среда",
        "четверг",
        "пятница",
        "субботa",
        "воскресенье",
    )

    var days: MutableList<Day> = mutableListOf(
        Day(1, dayOfWeek[5], ""),
        Day(2, dayOfWeek[6], ""),
        Day(3, dayOfWeek[0], ""),
        Day(4, dayOfWeek[1], ""),
        Day(5, dayOfWeek[2], ""),
        Day(6, dayOfWeek[3], ""),
        Day(7, dayOfWeek[4], ""),
        Day(8, dayOfWeek[5], ""),
        Day(9, dayOfWeek[6], ""),
        Day(10, dayOfWeek[0], ""),
        Day(11, dayOfWeek[1], ""),
        Day(12, dayOfWeek[2], ""),
        Day(13, dayOfWeek[3], ""),
        Day(14, dayOfWeek[4], ""),
        Day(15, dayOfWeek[5], ""),
        Day(16, dayOfWeek[6], ""),
        Day(17, dayOfWeek[0], ""),
        Day(18, dayOfWeek[1], ""),
        Day(19, dayOfWeek[2], ""),
        Day(20, dayOfWeek[3], ""),
        Day(21, dayOfWeek[4], ""),
        Day(22, dayOfWeek[5], ""),
        Day(23, dayOfWeek[6], ""),
        Day(24, dayOfWeek[0], ""),
        Day(25, dayOfWeek[1], ""),
        Day(26, dayOfWeek[2], ""),
        Day(27, dayOfWeek[3], ""),
        Day(28, dayOfWeek[4], ""),
        Day(29, dayOfWeek[5], ""),
        Day(30, dayOfWeek[6], ""),
        Day(31, dayOfWeek[0], ""),
    )

    fun changeToFollowing(group: String) {
        val num = groupToId(group)
        when (num) {
            301 -> {
                days[10].subject = exams[0]
                days[14].subject = exams[1]
                days[18].subject = exams[2]
                days[23].subject = exams[3]
                days[26].subject = exams[4]
            }
            302 -> {
                days[7].subject = exams[1]
                days[12].subject = exams[0]
                days[16].subject = exams[3]
                days[20].subject = exams[2]
                days[25].subject = exams[4]
            }
            303 -> {
                days[9].subject = exams[3]
                days[13].subject = exams[0]
                days[17].subject = exams[1]
                days[21].subject = exams[2]
                days[24].subject = exams[4]
            }
            304 -> {
                days[9].subject = exams[1]
                days[14].subject = exams[0]
                days[17].subject = exams[4]
                days[21].subject = exams[3]
                days[26].subject = exams[2]
            }
            305 -> {
                days[9].subject = exams[0]
                days[16].subject = exams[2]
                days[20].subject = exams[1]
                days[24].subject = exams[3]
                days[27].subject = exams[4]
            }
            306 -> {
                days[7].subject = exams[0]
                days[12].subject = exams[1]
                days[17].subject = exams[3]
                days[23].subject = exams[2]
                days[26].subject = exams[4]
            }
        }
    }

    private fun groupToId(name: String) : Int {
        return Integer.parseInt(name.substring(name.indexOf('-')+1))
    }
}