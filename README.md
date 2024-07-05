# IO Projekt

## Áttekintés
Ez a projekt különböző Java parancsok megvalósítását tartalmazza, amelyek különféle shell parancsokat szimulálnak, mint például a `cd`, `ls`, `pwd`, `grep` és mások.

## Struktúra
A fő fájlok és azok célja a következő:
- `Main.java`: Az alkalmazás belépési pontja.
- `Command.java`: Egy absztrakt osztály, amely meghatározza az összes parancs szerkezetét.
- Különféle parancs megvalósítások (pl. `HeadCommand.java`, `TailCommand.java`, `WcCommand.java`, stb.), amelyek specifikus funkciókat biztosítanak.

## Parancsok
Itt található egy rövid áttekintés az egyes parancsokról, amelyek ebben a projektben kerültek megvalósításra:

- **CdCommand**: Az aktuális könyvtár módosítása.
- **LsCommand**: Fájlok és könyvtárak listázása az aktuális könyvtárban.
- **PwdCommand**: Az aktuális munkakönyvtár megjelenítése.
- **GrepCommand**: Sorok keresése egy fájlban adott minták alapján.
- **HeadCommand**: A fájl elejének megjelenítése.
- **TailCommand**: A fájl végének megjelenítése.
- **WcCommand**: Szavak, sorok és karakterek számlálása egy fájlban.
- **CatCommand**: Fájlok tartalmának megjelenítése.
- **LengthCommand**: A fájl hosszának meghatározása.
- **MkDirCommand**: Új könyvtár létrehozása.
- **MvCommand**: Fájlok vagy könyvtárak áthelyezése.
- **CpCommand**: Fájlok vagy könyvtárak másolása.
- **RmCommand**: Fájlok vagy könyvtárak törlése.

## Használat
1. Győződj meg róla, hogy a Java telepítve van a számítógépeden.
2. Nyisd meg a terminált, és navigálj a projekt könyvtárába.
3. Fordítsd le a projektet a következő parancs segítségével:
   javac Main.java
4. Futtasd az alkalmazást:
   java Main
