package com.app.Subjects.Textbook

import android.content.Context
import android.content.SharedPreferences

class TextbookRepository private constructor(context: Context) {
    companion object {
        @Volatile
        private var instance: TextbookRepository? = null

        fun getInstance(context: Context): TextbookRepository {
            if (instance == null) {
                instance = TextbookRepository(context)
            }
            return instance!!
        }
    }

    private var sharedPreferences: SharedPreferences? = null

    var like: List<Textbook> = listOf()

    fun update() {
        val arr = getFrom()

        textbooks.forEach {
            it.like = false
        }

        arr.forEach{
            textbooks[Integer.parseInt(it)-1].like = true
        }

        like = textbooks.filter {
            (it.like)
        }
    }

    fun init(context: Context) {
        sharedPreferences =
            context.getSharedPreferences("textbooksSharedPrefs", Context.MODE_PRIVATE)
    }

    fun add() {
        val editor = sharedPreferences?.edit()
        var sss = textbooks.filter {
            (it.like)
        } .map {
            it.idTextbook.toString()
        } .toSet()

        editor?.putStringSet("set", sss)
        editor?.apply()
    }

    fun getFrom(): ArrayList<String> {
        val sss = sharedPreferences?.getStringSet("set", emptySet())?.toSet()
        val myArrayList = arrayListOf<String>()
        myArrayList.addAll(sss!!)
        return myArrayList
    }

    var textbooks: List<Textbook> = listOf(
        Textbook(
            idSubject = 1,
            idTextbook = 1,
            titleAndAuthor = "В.А. Ильин, Э.Г. Позняк «Аналитическая геометрия»",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            url = "https://djvu.online/file/EdF3SCk04YRRw?ysclid=ly77x20c2s649161780",
            like = false
        ),
        Textbook(
            idSubject = 1,
            idTextbook = 2,
            titleAndAuthor = "В.А. Ильин, Э.Г. Позняк «Линейная алгебра»",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            url = "https://djvu.online/file/cswHYw9a1z97G?ysclid=ly789fbybl305354262",
            like = false
        ),
        Textbook(
            idSubject = 1,
            idTextbook = 3,
            titleAndAuthor = "Н.Н. Корнеева, М.Ф. Насрутдинов, Ф.Ф. Шарифуллина «Сборник задач по аналитической геометрии»",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            //video photoUrl = "https://thumbs.dreamstime.com/b/%C3%B0%C2%B7%C3%B0%C2%BD%C3%B0%C2%B0%C3%B1%E2%80%A1o%C3%B0%C2%BA-%C3%B0%C2%B2%C3%B0%C2%B5%C3%B0%C2%BA%C3%B1%E2%80%9Ao%C3%B1%E2%82%AC%C3%B0%C2%B0-%C3%B1%E2%80%A0%C3%B0%C2%B2%C3%B0%C2%B5%C3%B1%E2%80%9A%C3%B0%C2%B0-%C3%B0%C2%B3%C3%B0%C2%BB%C3%B0%C2%B8%C3%B1%E2%80%9E%C3%B0%C2%B0-mediaplayer-%C3%B0%C2%BF%C3%B0%C2%BBo%C3%B1%C2%81%C3%B0%C2%BA%C3%B0%C2%B8%C3%B0%C2%B9-%C3%B1%C2%8D%C3%B0%C2%BB%C3%B0%C2%B5%C3%B0%C2%BC%C3%B0%C2%B5%C3%B0%C2%BD%C3%B1%E2%80%9A%C3%B1%E2%80%B9-%C3%B0-%C3%B0%C2%BB%C3%B1%C2%8F-%C3%B0%C2%BF%C3%B0%C2%B5%C3%B1%E2%82%AC%C3%B0%C2%B5%C3%B0-%C3%B0%C2%B2%C3%B0%C2%B8%C3%B0%C2%B6%C3%B0%C2%BD%C3%B1%E2%80%B9%C3%B1%E2%80%A6-apps-142246264.jpg",
            //photoUrl = "https://rowdydogimages.com/edgeanimate_assets/SHSbow/Assets/images/13614182-glassy-aqua-blue-play-icon.jpg",
            url = "https://dspace.kpfu.ru/xmlui/bitstream/handle/net/34773/nas_geom.pdf?sequence=1",
            like = false
        ),
        Textbook(
            idSubject = 1,
            idTextbook = 4,
            titleAndAuthor = "Расписанные билеты ",
            photoUrl = "https://steelpine.ru/wp-content/uploads/2019/04/dokument-ikonka.jpg",
            url = "https://docs.google.com/document/d/1HLseg_qUlOBP8NLpnG3UjT1_pJpOhx1WHrmfd4mtS70/edit?usp=sharing",
            like = false
        ),
        Textbook(
            idSubject = 2,
            idTextbook = 5,
            titleAndAuthor = "М.О. Асанов, В.А. Баранский, В.В. Расин «Дискретная математика: графы, матроиды, алгоритмы»",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            url = "http://publ.lib.ru/ARCHIVES/U/''Uchebniki_dlya_vuzov''_(seriya)/%C0%F1%E0%ED%EE%E2%20%CC.%CE.,%20%C1%E0%F0%E0%ED%F1%EA%E8%E9%20%C2.%C0.,%20%D0%E0%F1%E8%ED%20%C2.%C2._%20%C4%E8%F1%EA%F0%E5%F2%ED%E0%FF%20%EC%E0%F2%E5%EC%E0%F2%E8%EA%E0.%20%C3%F0%E0%F4%FB,%20%EC%E0%F2%F0%EE%E8%E4%FB,%20%E0%EB%E3%EE%F0%E8%F2%EC%FB.(2020).pdf",
            like = false
        ),
        Textbook(
            idSubject = 2,
            idTextbook = 6,
            titleAndAuthor = "Ю.А. Альпин, С.Н. Ильин «Дискретная математика: графы и автоматы»",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            url = "https://kpfu.ru/docs/F1178179133/DM_zadachi.pdf",
            like = false
        ),
        Textbook(
            idSubject = 2,
            idTextbook = 7,
            titleAndAuthor = "Расписанные билеты",
            photoUrl = "https://steelpine.ru/wp-content/uploads/2019/04/dokument-ikonka.jpg",
            url = "https://drive.google.com/file/d/1go76gTUVw4h083-30G_Qq96zWazzGkDF/view",
            like = false
        ),
        Textbook(
            idSubject = 2,
            idTextbook = 8,
            titleAndAuthor = "Расписанные билеты",
            photoUrl = "https://steelpine.ru/wp-content/uploads/2019/04/dokument-ikonka.jpg",
            url = "https://docs.google.com/document/d/1mVlwkmXzCRZ40N-J6jPJgvi6Lr7dQbgZDiqaNdpMcIw/edit?usp=sharing",
            like = false
        ),
        Textbook(
            idSubject = 2,
            idTextbook = 9,
            titleAndAuthor = "Г.П. Гаврилов, А.А. Сапоженко «Задачи и упражнения по дискретной математике»",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            url = "https://djvu.online/file/0apxedmv9Z4Hu?ysclid=ly79hhpnwg134799406",
            like = false
        ),
        Textbook(
            idSubject = 3,
            idTextbook = 10,
            titleAndAuthor = "Все лекции",
            photoUrl = "https://steelpine.ru/wp-content/uploads/2019/04/dokument-ikonka.jpg",
            url = "https://docs.google.com/document/d/1ZBWuC0ezTCeb6Lv0f6QDhaKFcmdgPuAjMRKEfXnHSZE/edit#heading=h.pn54avwhlpo",
            like = false
        ),
        Textbook(
            idSubject = 3,
            idTextbook = 11,
            titleAndAuthor = "Б.П. Демидович «Сборник задач по математическому анализу»",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            url = "https://chembaby.ru/wp-content/uploads/2019/02/%D0%A1%D0%B1%D0%BE%D1%80%D0%BD%D0%B8%D0%BA-%D0%B7%D0%B0%D0%B4%D0%B0%D1%87-%D0%B8-%D1%83%D0%BF%D1%80.-%D0%BF%D0%BE-%D0%BC%D0%B0%D1%82.-%D0%B0%D0%BD%D0%B0%D0%BB%D0%B8%D0%B7%D1%83_%D0%94%D0%B5%D0%BC%D0%B8%D0%B4%D0%BE%D0%B2%D0%B8%D1%87_2005-560%D1%81.pdf?ysclid=ly7a68plfe879861974",
            like = false
        ),
        Textbook(
            idSubject = 4,
            idTextbook = 12,
            titleAndAuthor = "Расписанные билеты",
            photoUrl = "https://steelpine.ru/wp-content/uploads/2019/04/dokument-ikonka.jpg",
            url = "https://docs.google.com/document/d/15dxkfKQUWx8FgXsBkGTCYsYc59FpX60EXJlN15baOeA/edit?usp=sharing",
            like = false
        ),
        Textbook(
            idSubject = 4,
            idTextbook = 13,
            titleAndAuthor = "Презентации с лекций ",
            photoUrl = "https://steelpine.ru/wp-content/uploads/2019/04/dokument-ikonka.jpg",
            url = "https://drive.google.com/drive/folders/1tmJ-n7PrneUZaFoVwriE_FQYF20gNmJZ?usp=sharing",
            like = false
        ),
        Textbook(
            idSubject = 5,
            idTextbook = 14,
            titleAndAuthor = "Быстрые вопросы и практика",
            photoUrl = "https://steelpine.ru/wp-content/uploads/2019/04/dokument-ikonka.jpg",
            url = "https://docs.google.com/document/d/1GxagHzpYz9gEwXabzdRkJeByCVaqfikb-hkU9kUm2XE/edit?usp=sharing",
            like = false
        ),
        Textbook(
            idSubject = 5,
            idTextbook = 15,
            titleAndAuthor = "Расписанные билеты ",
            photoUrl = "https://steelpine.ru/wp-content/uploads/2019/04/dokument-ikonka.jpg",
            url = "https://docs.google.com/document/d/1ZF_CymdLraNMIjgKYJCZfqlWUXoDDm2EMoiHJ_FlSyw/edit#heading=h.6ili1cvxct67",
            like = false
        ),
        Textbook(
            idSubject = 5,
            idTextbook = 16,
            titleAndAuthor = "Варианты задач",
            photoUrl = "https://steelpine.ru/wp-content/uploads/2019/04/dokument-ikonka.jpg",
            url = "https://www.interviewbit.com/courses/programming/",
            like = false
        ),
        Textbook(
            idSubject = 5,
            idTextbook = 17,
            titleAndAuthor = "Варианты задач",
            photoUrl = "https://steelpine.ru/wp-content/uploads/2019/04/dokument-ikonka.jpg",
            url = "https://acmp.ru/",
            like = false
        ),
        Textbook(
            idSubject = 5,
            idTextbook = 18,
            titleAndAuthor = "Варианты задач",
            photoUrl = "https://steelpine.ru/wp-content/uploads/2019/04/dokument-ikonka.jpg",
            url = "https://codeforces.com/",
            like = false
        ),
        Textbook(
            idSubject = 5,
            idTextbook = 19,
            titleAndAuthor = "Т. Кормен, Ч. Лейзерсон, Р. Ривест, К. Штайн «Алгоритмы. Построение и анализ»",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            url = "http://e-maxx.ru/bookz/files/cormen.pdf",
            like = false
        ),
        Textbook(
            idSubject = 5,
            idTextbook = 20,
            titleAndAuthor = "Н. Вирт «Алгоритмы + Структуры данных = Программа»",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            url = "https://doc.lagout.org/science/0_Computer%20Science/2_Algorithms/Algorithms%20and%20Data%20Structures%20(RU).pdf",
            like = false
        ),
        Textbook(
            idSubject = 5,
            idTextbook = 21,
            titleAndAuthor = "Записи лекций",
            photoUrl = "https://thumbs.dreamstime.com/b/%C3%B0%C2%B7%C3%B0%C2%BD%C3%B0%C2%B0%C3%B1%E2%80%A1o%C3%B0%C2%BA-%C3%B0%C2%B2%C3%B0%C2%B5%C3%B0%C2%BA%C3%B1%E2%80%9Ao%C3%B1%E2%82%AC%C3%B0%C2%B0-%C3%B1%E2%80%A0%C3%B0%C2%B2%C3%B0%C2%B5%C3%B1%E2%80%9A%C3%B0%C2%B0-%C3%B0%C2%B3%C3%B0%C2%BB%C3%B0%C2%B8%C3%B1%E2%80%9E%C3%B0%C2%B0-mediaplayer-%C3%B0%C2%BF%C3%B0%C2%BBo%C3%B1%C2%81%C3%B0%C2%BA%C3%B0%C2%B8%C3%B0%C2%B9-%C3%B1%C2%8D%C3%B0%C2%BB%C3%B0%C2%B5%C3%B0%C2%BC%C3%B0%C2%B5%C3%B0%C2%BD%C3%B1%E2%80%9A%C3%B1%E2%80%B9-%C3%B0-%C3%B0%C2%BB%C3%B1%C2%8F-%C3%B0%C2%BF%C3%B0%C2%B5%C3%B1%E2%82%AC%C3%B0%C2%B5%C3%B0-%C3%B0%C2%B2%C3%B0%C2%B8%C3%B0%C2%B6%C3%B0%C2%BD%C3%B1%E2%80%B9%C3%B1%E2%80%A6-apps-142246264.jpg",
            url = "https://www.youtube.com/playlist?list=PL3sQllj7sKocsmx8IQorWIy-YsZdWX5zq",
            like = false
        ),

        Textbook(
            idSubject = 6,
            idTextbook = 22,
            titleAndAuthor = "А. С. Орлов, А. Ю. Полунов, Ю. Я. Терещенко «Основы курса истории России»",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            url = "https://vk.com/doc201187333_657747432?hash=cShcM9mYZGM3SLJ0S9zw6ruABzsg73kEDUKe79GsmHP&dl=nYYq1j7TNVkKdjcfahzU7PKnvK97Un0UA7o1iMj0NYk",
            like = false
        ),
        Textbook(
            idSubject = 6,
            idTextbook = 23,
            titleAndAuthor = "Федоров В.А. «История России. 1861 – 1917»",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            url = "https://www.hist.msu.ru/upload/iblock/5f1/sum58496.pdf",
            like = false
        ),
        Textbook(
            idSubject = 6,
            idTextbook = 24,
            titleAndAuthor = "Сахаров А.Н., Боханов А.Н., Шестаков В.А.  «История России с древнейших времен до наших дней» ",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            url = "https://go.11klasov.net/20132-istorija-rossii-s-drevnejshih-vremen-do-nashih-dnej-v-2-h-tomah-saharov-an-bohanov-an-shestakov-va.html",
            like = false
        ),
        Textbook(
            idSubject = 6,
            idTextbook = 25,
            titleAndAuthor = "Уральский Федеральный Университет «История России для иностранных студентов»",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            url = "https://elar.urfu.ru/bitstream/10995/100286/1/978-5-7996-3217-5_2021.pdf",
            like = false
        ),
        Textbook(
            idSubject = 6,
            idTextbook = 26,
            titleAndAuthor = "КФУ «HISTORY ИСТОРИЯ Учебное пособие для иностранных студентов на английском языке»",
            photoUrl = "https://grizly.club/uploads/posts/2023-08/1692305239_grizly-club-p-kartinki-znachok-knigi-bez-fona-45.jpg",
            url = "https://dspace.kpfu.ru/xmlui/bitstream/handle/net/158729/F_Istoriya__istory.pdf?sequence=-1",
            like = false
        )
    )
}