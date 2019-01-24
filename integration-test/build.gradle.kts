
import com.hendraanggrian.markdown.github.h1
import com.hendraanggrian.markdown.github.h3

plugins {
    id("com.hendraanggrian.markdown")
}

markdown {
    isPrettyPrint = true
    write("output", "letter") {
        header("A letter")
        paragraph("To whom may it concern ...")
    }
    write("output", "github-repo") {
        h1("Awesome app")
        paragraph("With cool extra features.")
        h3("Screenshots")
        
    }
}