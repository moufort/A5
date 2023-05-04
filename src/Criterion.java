//import org.w3c.dom.css.CSSValueList;

public class Criterion{

    private String value;
    private CriterionName label;
    
    public Criterion(String value , CriterionName label){
        this.value = value;
        this.label = label;
    }

    /* Regarde si des critéres donné sont valides ou non */
    public boolean isValid(){

        if(this.label.getType() == 'B'){
            return this.value.equals("yes") || this.value.equals("no");
        }
        else if (this.label.getType() == 'T'){
            // avec un instanceof
            if (this.value instanceof String) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
        /*else if(this.label.getType() == 'T'){
            return this.value.equals(label) 
        }else if(this.label.getType() == 'N'){
            return
        }else if(this.label.getType() == 'D'){
            return this.value.equals(label) 
        }*/
    }


    public CriterionName getLabel() {
        return label;
    }

    public String getvalue(){
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Criterion other = (Criterion) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (label != other.label)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Criterion [value=" + value + ", label=" + label + "]";
    }
}