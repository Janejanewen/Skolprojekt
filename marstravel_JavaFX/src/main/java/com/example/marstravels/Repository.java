package com.example.marstravels;
import javaClass.*;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    // insert data för cabin-klass
    Cabin cabin1 = new Cabin(1,"Svit",2, 29999, "Svit-hyttalternativet är utformat för resenärer som söker en mer lyxig och avskild upplevelse på sin rymdresa till Mars. \n" +
            "\n" +
            "Hytten har stora fönster som ger fantastisk utsikt över rymden och är uppdelad i ett separat vardagsrum och sovrum med en bekväm dubbelsäng. \n" +
            "\n" +
            "Hytten är också utrustad med en stor tv-skärm med ett brett utbud av underhållning som filmer, serier, musik och spel. För att öka bekvämligheten har hytten ett eget badrum med både badkar och dusch, samt en toalett. \n" +
            "\n" +
            "Frukost ingår också i priset, vilket ger resenärerna en bekväm start på dagen."  );
    Cabin cabin2 = new Cabin(2,"Spaceside",2, 32599, "Spaceside-hyttalternativet är också utrustat med stora fönster som ger fantastisk utsikt över den spektakulära rymden. \n" +
            "\n" +
            "Hytten har en bekväm dubbelsäng och en stor tv-skärm med ett brett utbud av underhållning som filmer, serier, musik och spel. \n" +
            "\n" +
            "Hytten har också ett eget badrum med en dusch och en toalett för att öka bekvämligheten för resenärerna.");
    Cabin cabin3 = new Cabin(3,"Inside",2, 25990, "Inside-hyttalternativet med två underbäddar som kan ändras till soffa dagtid är utformat för resenärer som reser i ett mindre sällskap. \n" +
            "\n" +
            "Hytten är utrustad med två bekväma underbäddar som kan ändras till soffa dagtid, vilket ger resenärerna mer utrymme att röra sig under dagen. \n" +
            "\n" +
            "Hytten har också ett eget badrum med en dusch och en toalett för att öka bekvämligheten för resenärerna.\n" +
            "\n" +
            "Låt er inte luras utav bilden att ni har en vy av den graciösa rymden, insidehytten ligger mitt i rymdskeppet utan utsikt. Fönstret är enbart en loopande bild av tidigare rymdresor via en projektor i taket. ");
    Cabin cabin4 = new Cabin(4,"Economy",4, 29999, "Economy-hyttalternativet är det mest kostnadseffektiva alternativet för resenärer som söker en enkel och grundläggande hytt under sin rymdresa till Mars. \n" +
            "\n" +
            "Hytten är utrustad med fyra bäddar, två under- och två överbäddar, där underbäddarna kan ändras till soffa dagtid.\n" +
            "\n" +
            "Trots att toaletter finns i korridoren, finns det också en privat dusch i hytten.");
    Cabin cabin5 = new Cabin(5,"Sömnkapsel",1, 19999, "Kapselalternativet innebär att man blir nedsövd och sover under hela resan. \n" +
            "\n" +
            "Kapseln är en liten, isolerad behållare med en enkelsäng, minimalt förvaringsutrymme och en dusch och toalett i anslutning till den. \n" +
            "\n" +
            "Resenärer som väljer kapseln kommer att vakna upp på Mars och undviker därmed alla långa och tråkiga timmar på rymdskeppet.");
    // metoder som använder för att hämta cabin-klass
    private List<Cabin> cabins = new ArrayList<>();
    public List<Cabin> getcabins()
    {
        cabins.add(cabin1);
        cabins.add(cabin2);
        cabins.add(cabin3);
        cabins.add(cabin4);
        cabins.add(cabin5);

        List<Cabin> getcabins = new ArrayList<>();
        for (Cabin cabin : cabins)
        {
            getcabins.add(cabin);
        }
            return getcabins;
    }

    //*FoodPackage repository**
    FoodPackage budget1 = new FoodPackage(1,"budget1",1999);
    FoodPackage budget2 = new FoodPackage(2,"budget2",1999);
    FoodPackage budget3 = new FoodPackage(3,"budget3",1999);
    FoodPackage mellan1 = new FoodPackage(4,"mellan1",2599);
    FoodPackage mellan2 = new FoodPackage(5,"mellan2",2599);
    FoodPackage mellan3 = new FoodPackage(6,"mellan3",2599);
    FoodPackage lyx1 = new FoodPackage(7,"lyx1",2999);
    FoodPackage lyx2 = new FoodPackage(8,"lyx2",2999);
    FoodPackage lyx3 = new FoodPackage(9,"lyx3",2999);
    private List<FoodPackage> foods = new ArrayList<>();
    public List<FoodPackage> getFoods()
    {
        foods.add(budget1);
        foods.add(budget2);
        foods.add(budget3);
        foods.add(mellan1);
        foods.add(mellan2);
        foods.add(mellan3);
        foods.add(lyx1);
        foods.add(lyx2);
        foods.add(lyx3);

        List<FoodPackage> getFoods = new ArrayList<>();
        for (FoodPackage food : foods)
        {
            getFoods.add(food);
        }
        return getFoods;
    }

    // **FoodPackage repository slut **
//** FoodInfo**
    FoodInfo matInfo = new FoodInfo(1,"Restauranger finns fyra olika som serverar all typ av mat och dryck.  \n" +
            " \n" +
            "Det billigaste alternativet är MarsDonald vars utbud är 2 olika frukostar, 3 olika luncher \n" +
            "och 4 olika middagar, samt 3 olika kakor/desserter att tillgå mellan måltiderna. \n" +
            " \n" +
            "Marsian Buffé är restaurangen som har buffé dygnet runt med olika rätter som kan passa \n" +
            "oavsett tid på dagen. Alltifrån våfflor och omeletter till grillat och pizza.  \n" +
            " \n" +
            "Vi har också restaurangen Tellus Home som serverar en enklare frukostbuffé, 5 olika \n" +
            "luncher (kött/fisk/veg/soppa/pasta) och 6 olika middagar (2 alternativ av \n" +
            "fisk/kött/veg). Deras dessertbuffé som är öppen mellan måltiderna består av 3-5 olika \n" +
            "kakor/desserter plus dryck. \n" +
            " \n" +
            "Spaceview restaurangen har specialiserat sig på ny och kreativ mat där kockarna tar \n" +
            "favoriträtter från jorden och med inspiration från rymden gör om dem och ger dig en ny \n" +
            "smakupplevelse.  \n" +
            " \n" +
            "Då planeringen behöver göras för resan och mathållningen så måste man boka ett av \n" +
            "nedanstående paket. Måltiderna serveras enligt rullande schema så man får olika \n" +
            "måltider olika dagar.  ");

    FoodInfo budget= new FoodInfo (2,"Budget 1:\n" +
            "Samtliga måltider under resan intas på MarsDonalds. \n" +
            "\n" +
            "Budget 2: \n" +
            "All frukost och lunch intas på MarsDonalds medan mellanmål och middagarna intas på \n" +
            "Marsian Buffé.  \n" +
            "\n" +
            "Budget 3:  \n" +
            "Samtliga måltider under resan intas på Marsian Buffé. ");

    FoodInfo mellan= new FoodInfo(3,"Mellan 1: \n" +
            "All frukost intas på MarsDonalds, mellanmål och lunch på Marsian Buffé medan \n" +
            "middagarna intas på Tellus Home.  \n" +
            "\n" +
            "Mellan 2: \n" +
            "All måltider förutom middag intas på Marsian Buffé. Middagarna intas på Tellus Home. \n" +
            "\n" +
            "Mellan 3: \n" +
            "Samtliga måltider intas på Tellus Home. ");

    FoodInfo lyx=new FoodInfo(4,"Lyx 1: \n" +
            "All måltider förutom middag intas på Tellus Home medan middagarna intas på \n" +
            "SpaceView.  \n" +
            "\n" +
            "Lyx 2: \n" +
            "Frukost och mellanmål intas på Tellus Home medan lunch och middag intas på \n" +
            "SpaceView \n" +
            "\n" +
            "Lyx 3: \n" +
            "Samtliga måltider intas på SpaceView. För de som valt hyttalternativet Svit serveras \n" +
            "frukosten i hytten från SpaceView.  ");

    private List<FoodInfo> infos = new ArrayList<>();
    public List<FoodInfo> getFoodinfos()
    {
        infos.add(matInfo);
        infos.add(budget);
        infos.add(mellan);
        infos.add(lyx);

        List<FoodInfo> getFoodinfos = new ArrayList<>();
        for (FoodInfo info : infos)
        {
            getFoodinfos.add(info);
        }
        return getFoodinfos;
    }

//**********Event*****************
Event film = new Event(1,"Filmpremiär",19,
        "Januari:\n" +
        "\"The Last Hope\" - Warner Bros. \n" +
        "\n" +
        "Februari:\n" +
        "\"Revolutionary Minds\" - Universal Pictures\n" +
        "\n" +
        "Mars:\n" +
        "\"The Mind's Eye\" - Paramount Pictures\n" +
        "\n" +
        "April:\n" +
        "\"The Lost City\" - Sony Pictures\n" +
        "\n" +
        "Maj:\n" +
        "\"Dark Matter\" - 20th Century Studios\n" +
        "\n" +
        "Juni:\n" +
        "\"The New Wave\" - Netflix\n" +
        "\n" +
        "Juli:\n" +
        "\"The Fifth Element\" - EuropaCorp\n" +
        "\n" +
        "Augusti:\n" +
        "\"The Phoenix Project\" - Lionsgate\n" +
        "\n" +
        "September:\n" +
        "\"The Timekeeper\" - Disney\n" +
        "\n" +
        "Oktober:\n" +
        "\"The Water Boy\" - Warner Bros.\n" +
        "\n" +
        "November:\n" +
        "\"2045\" - SF Studios\n" +
        "\n" +
        "December:\n" +
        "\"Christmas Attack\" - Lionsgate\n" +
        "\n" +
        "\n" +
        "\n");
    Event konsert = new Event(2,"Konserter",20,
            "Januari:\n" +
            "Adele - \"Hello World Tour\"\n" +
            "\n" +
            "Februari:\n" +
            "Bruno Mars and Cardi B - \"Finesse It Up Tour\"\n" +
            "\n" +
            "Mars\n" +
            "Coldplay - \"Sky Full of Stars Tour\"\n" +
            "\n" +
            "April:\n" +
            "Drake and Rihanna - \"Work It Out Tour\"\n" +
            "\n" +
            "Maj:\n" +
            "Ed Sheeran and Taylor Swift - \"Red Divide Tour\"\n" +
            "\n" +
            "Juni:\n" +
            "Fleetwood Mac and Stevie Nicks - \"Go Your Own Way Tour\"\n" +
            "\n" +
            "Juli:\n" +
            "Justin Bieber - \"Purpose World Tour: Reloaded\"\n" +
            "\n" +
            "Augusti:\n" +
            "Katy Perry - \"Roar & Fireworks Tour\"\n" +
            "\n" +
            "September:\n" +
            "Lady Gaga - \"Chromatica Ball Tour\"\n" +
            "\n" +
            "Oktober:\n" +
            "Post Malone and Billie Eilish - \"Bad & Better Tour\"\n" +
            "\n" +
            "November:\n" +
            "Shawn Mendes - \"Wonderland Tour\"\n" +
            "\n" +
            "December:\n" +
            "The Weeknd and Halsey - \"After Hours Together Tour\"");
    Event teat = new Event(3,"Teaterpremiär",15,
            "Januari - Februari\n" +
            "\"SOLALA Vol 1\" \n" +
            "- Produced by Shakespeare Repertory Company\n" +
            "\n" +
            "Mars - April\n" +
            "\"The Phantom of the Opera\" \n" +
            "- Produced by Broadway Productions\n" +
            "\n" +
            "Maj - Juni\n" +
            "\"Les Misérables: The Musical\" \n" +
            "- Produced by West End Productions\n" +
            "\n" +
            "Juli - Augusti\n" +
            "\"Hamilton: An American Musical\" \n" +
            "- Produced by Lin-Manuel Miranda Productions\n" +
            "\n" +
            "September - Oktober\n" +
            "\"The Lion King: The Musical\" \n" +
            "- Produced by Disney Theatrical Productions\n" +
            "\n" +
            "November - December\n" +
            "\"Wicked: The Untold Story of the Witches of Oz\"\n" +
            "- Produced by Universal Stage Productions");



    //HotelInformation

    private List<Hotel> hotels = new ArrayList<>();
    public List<Hotel> gethotels()
    {
        hotels.add(hotel1);
        hotels.add(hotel2);
        hotels.add(hotel3);
        hotels.add(hotel4);
        hotels.add(hotel5);

        List<Hotel> gethotels = new ArrayList<>();
        for (Hotel hotel : hotels)
        {
            gethotels.add(hotel);
        }
        return gethotels;
    }

    Hotel hotel1 = new Hotel(1, "Hilton", "Hilton-hotellet på Mars är en av de mest exklusiva destinationerna i solsystemet. Hotellet ligger i en avskild dal vid foten av Olympus Mons, den största vulkanen i solsystemet. Utsikten från hotellet är enastående och sträcker sig ända till horisonten.\n" +
            "\n" +
            "Hotellet har en mängd olika bekvämligheter för gästerna att njuta av. Det finns en spa-avdelning med en avkopplande jacuzzi som är fylld med varmt, mineralrikt vatten från en källa som ligger några kilometer bort. Gästerna kan också träna på hotellets gym, som är utrustat med den senaste tekniken.\n" +
            "\n" +
            "Hotellet har också flera restauranger som serverar en mängd olika rätter. En av de mest populära restaurangerna serverar rätter som är inspirerade av Mars röda stenar och järnrika jord. Det finns också en bar på taket av hotellet där gästerna kan njuta av utsikten medan de dricker sin favoritdrink.\n" +
            "\n" +
            "Gästerna kan välja mellan olika rumskategorier, från enkla standardrum till stora sviter med privat balkong och jacuzzi. Alla rum har moderna bekvämligheter som Wi-Fi, platt-TV och bekväma sängar.\n" +
            "\n" +
            "Hotellet har också en mängd olika aktiviteter för gästerna att delta i. Det finns guidade turer till Olympus Mons, vandringar i dalen och till och med möjligheten att åka på en liten rymdfärd runt planeten.\n" +
            "\n" +
            "Hilton-hotellet på Mars är verkligen en av de mest unika och lyxiga destinationerna i hela solsystemet, och är ett måste-besök för alla som vill uppleva vad framtiden har att erbjuda.");
    Hotel hotel2 = new Hotel(2, "Atman Resorts", "Atman Resorts hotellet på Mars är ett paradis för de som söker lyx och avkoppling. Beläget i en frodig dal vid foten av den majestätiska Marineris-dalen, är hotellets omgivningar en fröjd för ögat.\n" +
            "\n" +
            "Inne på hotellet finner man alla de bekvämligheter som behövs för att göra vistelsen oförglömlig. Hotellets spa-avdelning är en oas av lugn där gästerna kan njuta av en rad olika behandlingar. Avkoppling kan också upplevas i hotellets naturliga varma källor som är fyllda med mineralrikt vatten från en källa under ytan.\n" +
            "\n" +
            "Hotellets restaurang erbjuder en rad olika rätter och används av gästerna för både frukost, lunch och middag. Här serveras en mängd olika gourmeträtter, inspirerade av de lokala råvarorna från Mars. På kvällarna kan gästerna njuta av en drink vid hotellets bar medan de blickar ut över dalen och njuter av solnedgången.\n" +
            "\n" +
            "Rummen på Atman Resorts hotellet är utformade för att erbjuda maximal avkoppling och bekvämlighet. Alla rum är utrustade med en privat balkong med utsikt över dalen, en platt-TV och bekväma sängar. Här finns också en mängd olika rumskategorier, från enkla standardrum till stora sviter med privat pool och jacuzzi.\n" +
            "\n" +
            "Hotellet erbjuder också ett brett utbud av aktiviteter för gästerna att delta i. Från guidade turer av den närliggande dalen, till vandringar och mountainbiking på de omgivande kullarna. Dessutom kan gästerna också delta i rymdfärder som erbjuds av hotellet för att uppleva Mars från en helt ny vinkel.\n" +
            "\n" +
            "Atman Resorts hotellet på Mars är en verklig oas av lugn och avkoppling. Det är det perfekta stället att besöka för de som söker en unik och minnesvärd upplevelse på denna röda planet.");
    Hotel hotel3 = new Hotel(3, "Four Seasons", "Four Seasons hotell på Mars är en av de mest eftertraktade destinationerna i solsystemet. Beläget vid foten av Mons Olympus, den högsta vulkanen på Mars, bjuder hotellet på en spektakulär utsikt över planetens yta.\n" +
            "\n" +
            "Inne på hotellet hittar man alla bekvämligheter man kan önska sig. Hotellets spa erbjuder en mängd olika behandlingar som garanterat ger avkoppling för både kropp och själ. Det finns också en utomhuspool där gästerna kan ta ett dopp och njuta av utsikten över dalen.\n" +
            "\n" +
            "Hotellets restaurang är en av de mest populära i solsystemet, och erbjuder en mängd olika rätter som är inspirerade av Mars unika smaker och råvaror. Gästerna kan också koppla av i hotellets bar och njuta av en drink medan de blickar ut över den majestätiska dalen.\n" +
            "\n" +
            "Rummen på Four Seasons hotell är utformade för att garantera maximal komfort och avkoppling. Alla rum har en privat balkong med utsikt över dalen, en platt-TV och en bekväm säng. Det finns också en rad olika rumskategorier att välja mellan, inklusive sviter med egen jacuzzi och pool.\n" +
            "\n" +
            "Hotellet erbjuder också ett brett utbud av aktiviteter för gästerna att delta i. Guidade turer till Mons Olympus, mountainbike-utflykter och rymdfärder är bara några av de aktiviteter som gästerna kan njuta av.\n" +
            "\n" +
            "Four Seasons hotell på Mars är verkligen en destination utöver det vanliga. Det är det perfekta stället att besöka för de som söker en unik och lyxig upplevelse på denna röda planet.");
    Hotel hotel4 = new Hotel(4, "Jin Jiang", "Jin Jiang Intergalactic hotel på Mars är en destination för de som söker en verkligt unik och spännande upplevelse. Beläget på en höjd med utsikt över den mystiska Marineris-dalen, bjuder hotellet på enastående utsikt över den röda planetens yta.\n" +
            "\n" +
            "Hotellet har en rad olika bekvämligheter, inklusive en spa-avdelning där gästerna kan koppla av med en mängd olika behandlingar. Gästerna kan också njuta av den inomhuspool som är fylld med mineralrikt vatten från planetens yta.\n" +
            "\n" +
            "Jin Jiang Intergalactic hotel erbjuder också en mängd olika matupplevelser för sina gäster. Restaurangen serverar en mängd olika rätter från hela universum, inklusive rätter som är inspirerade av planetens egna råvaror och smaker. På hotellets bar kan gästerna njuta av en drink medan de blickar ut över Marineris-dalens mäktiga landskap.\n" +
            "\n" +
            "Rummen på Jin Jiang Intergalactic hotel är utformade för att ge gästerna maximal komfort och avkoppling. Alla rum har en privat balkong med utsikt över dalen, en platt-TV och bekväma sängar. Hotellet har också en rad olika rumskategorier att välja mellan, inklusive lyxiga sviter med egen jacuzzi och pool.\n" +
            "\n" +
            "Hotellet erbjuder också en mängd olika aktiviteter för gästerna att delta i. Det finns guidade turer i Marineris-dalen, utflykter till Mons Olympus och möjligheten att delta i en rymdfärd för att uppleva planeten från ett helt annat perspektiv.\n" +
            "\n" +
            "Jin Jiang Intergalactic hotel på Mars är en destination utöver det vanliga. Det är det perfekta stället att besöka för de som söker en verkligt unik och minnesvärd upplevelse på en annan planet.");
    Hotel hotel5 = new Hotel(5, "Marriot", "Marriott Intergalactic hotel på Mars är ett av de mest prestigefyllda hotellen i solsystemet. Beläget på en höjd med utsikt över den imponerande Marineris-dalen, erbjuder hotellet en enastående utsikt över planetens yta.\n" +
            "\n" +
            "Hotellet är utrustat med alla bekvämligheter man kan önska sig. Det finns en spa-avdelning där gästerna kan koppla av och njuta av olika behandlingar för kropp och själ. Hotellet har också en stor utomhuspool där gästerna kan simma och njuta av utsikten över dalen.\n" +
            "\n" +
            "Marriott Intergalactic hotel erbjuder en mängd olika matupplevelser för sina gäster. Restaurangen serverar en rad olika rätter från hela solsystemet, inklusive rätter som är inspirerade av Mars unika råvaror och smaker. Gästerna kan också koppla av på hotellets bar och njuta av en drink medan de blickar ut över dalen.\n" +
            "\n" +
            "Rummen på Marriott Intergalactic hotel är utformade för att ge gästerna maximal komfort och avkoppling. Alla rum har en privat balkong med utsikt över dalen, en platt-TV och bekväma sängar. Hotellet erbjuder också en rad olika rumskategorier att välja mellan, inklusive lyxiga sviter med egen jacuzzi och pool.\n" +
            "\n" +
            "Hotellet har också ett brett utbud av aktiviteter för gästerna att delta i. Det finns möjlighet till guidade turer i Marineris-dalen, rymdfärder och många andra spännande aktiviteter.\n" +
            "\n" +
            "Marriott Intergalactic hotel på Mars är en destination som bjuder på en unik och minnesvärd upplevelse. Det är det perfekta stället att besöka för de som söker lyx och komfort på en annan planet.");



    private List<Event> events = new ArrayList<>();
    public List<Event> getEvents()
    {
        events.add(film);
        events.add(konsert);
        events.add(teat);

        List<Event> getEvents = new ArrayList<>();
        for (Event event : events)
        {
            getEvents.add(event);
        }
        return getEvents;
    }
}
