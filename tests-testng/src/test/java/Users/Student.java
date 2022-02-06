package Users;

public class Student {
    private String firstName;
    private String firstNameLatin;
    private String lastName;
    private String lastNameLatin;
    private String blogName;
    private String birthDate;
    private String country;
    private String city;
    private String englishKnowledge;
    private String telegramNumber;
    private String whatsappNumber;

    private Student() {

    }

    public static Builder newBuilder() {
        return new Student().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder withFirstName(String name) {
            Student.this.firstName = name;
            return this;

        }

        public Builder withFirstNameLatin(String nameLatin) {
            Student.this.firstNameLatin = nameLatin;
            return this;
        }

        public Builder withLastName(String lastName) {
            Student.this.lastName = lastName;
            return this;
        }

        public Builder withLastNameLatin(String lastNameLatin) {
            Student.this.lastNameLatin = lastNameLatin;
            return this;
        }

        public Builder withBlogName(String blogName) {
            Student.this.blogName = blogName;
            return this;
        }

        public Builder withBirthDate(String birthDate) {
            Student.this.birthDate = birthDate;
            return this;
        }

        public Builder withCountry(String country) {
            Student.this.country = country;
            return this;
        }

        public Builder withCity(String city) {
            Student.this.city = city;
            return this;
        }

        public Builder withEnglishKnowledge(String englishKnowledge) {
            Student.this.englishKnowledge = englishKnowledge;
            return this;
        }

        public Builder withTelegramNumber(String telegramNumber) {
            Student.this.telegramNumber = telegramNumber;
            return this;
        }

        public Builder withWhatsappNumber(String whatsappNumber) {
            Student.this.whatsappNumber = whatsappNumber;
            return this;
        }

        public Student build() {
            return Student.this;
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public String getFirstNameLatin() {
        return firstNameLatin;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastNameLatin() {
        return lastNameLatin;
    }

    public String getBlogName() {
        return blogName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getEnglishKnowledge() {
        return englishKnowledge;
    }

    public String getTelegramNumber() {
        return telegramNumber;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }
}
