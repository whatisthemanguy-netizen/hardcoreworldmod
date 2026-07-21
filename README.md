# Hardcore World Mod (Fabric 1.20.1)

Turns the game brutal the moment it's on the server: shrinks the world to
**2500x2500** and locks the difficulty to **Hard**, no toggle, no going back.

## What it does
- **World border: 2500x2500**, centered on spawn (0, 0) — 1250 blocks in
  every direction. Applied to every dimension on the server.
- **Difficulty forced to Hard** — full mob damage, hunger can kill you,
  zombies break doors, harder raids/sieges.
- **Difficulty locked** — players and ops can't switch it back to
  Normal/Easy/Peaceful with `/difficulty` while the mod is installed.
- Applies automatically every time the server starts. No config file,
  no commands — just install it and it's on.

## Installing
1. Install [Fabric Loader](https://fabricmc.net/use/) for Minecraft 1.20.1
   on your server.
2. Grab [Fabric API](https://modrinth.com/mod/fabric-api) for 1.20.1 and
   drop it in `mods/` — this mod depends on it.
3. Build this mod (see below) or grab the jar from GitHub Actions, and drop
   it in `mods/` alongside Fabric API.
4. Start the server. The border and difficulty are applied as soon as the
   server finishes starting up.

## Building
Requires Java 17. Run `gradle build`; the jar lands in `build/libs/`.
This repo also builds automatically on GitHub — push, open **Actions**,
download the `hardcoreworldmod-jar` artifact.

## Notes
- Existing builds outside the 2500x2500 area aren't deleted, but players
  standing outside it will take border damage until they move back in.
- Because the border and difficulty lock are re-applied on every server
  start, removing the mod is the only way to lift them.
