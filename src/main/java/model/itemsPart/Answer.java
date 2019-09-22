package model.itemsPart;

public class Answer{
        private String text;
        private boolean isRight;

        public String getText() {
            return text;
        }

        public boolean isRight() {
            return isRight;
        }

        public Answer(String text, boolean isRight){
            this.text=text;
            this.isRight=isRight;
        }
    }