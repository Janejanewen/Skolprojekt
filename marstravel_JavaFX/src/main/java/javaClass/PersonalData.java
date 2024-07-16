package javaClass;

/**
 * Information of person with a name, email, personal number, etc.
 */
public class PersonalData {
    public String _Name;
    public String _adress;
    public String _cityName;
    public String _postNumber;
    public String _mailAdress;
    public String _healthDetails;

    public boolean _healthInsurance = false;

    public String _personNumber;
    public String _phoneNumber;
    public PersonalData(String _Name, String _adress, String _cityName,
                        String _personNumber, String _mailAdress, String _healthDetails, Boolean _healthInsurance,
                        String _postNumber, String _phoneNumber)
    {
        this._Name=_Name;
        this._adress=_adress;
        this._cityName=_cityName;
        this._personNumber=_personNumber;
        this._mailAdress=_mailAdress;
        this._healthDetails=_healthDetails;
        this._healthInsurance=_healthInsurance;
        this._postNumber=_postNumber;
        this._phoneNumber=_phoneNumber;
    }

    public String get_Name() {
        return _Name;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    public String get_adress() {
        return _adress;
    }

    public void set_adress(String _adress) {
        this._adress = _adress;
    }

    public String get_cityName() {
        return _cityName;
    }

    public void set_cityName(String _cityName) {
        this._cityName = _cityName;
    }

    public String get_postNumber() {
        return _postNumber;
    }

    public void set_postNumber(String _postNumber) {
        this._postNumber = _postNumber;
    }

    public String get_mailAdress() {
        return _mailAdress;
    }

    public void set_mailAdress(String _mailAdress) {
        this._mailAdress = _mailAdress;
    }

    public String get_healthDetails() {
        return _healthDetails;
    }

    public void set_healthDetails(String _healthDetails) {
        this._healthDetails = _healthDetails;
    }

    public boolean is_healthInsurance() {
        return _healthInsurance;
    }

    public void set_healthInsurance(boolean _healthInsurance) {
        this._healthInsurance = _healthInsurance;
    }

    public String get_personNumber() {
        return _personNumber;
    }

    public void set_personNumber(String _personNumber) {
        this._personNumber = _personNumber;
    }

    public String get_phoneNumber() {
        return _phoneNumber;
    }

    public void set_phoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }
}
