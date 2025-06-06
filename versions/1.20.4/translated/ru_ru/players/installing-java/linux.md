---
title: Установка Java на Linux
description: Пошаговая инструкция по установке Java на Linux.
authors:
  - IMB11

search: false
---

Этот гайд расскажет, как установить Java 17 на Linux.

## 1. Проверьте, не установлена ли Java

Откройте терминал, впишите `java -version` и нажмите <kbd>Enter</kbd>.

![Терминал с введённой командой "java -version"](/assets/players/installing-java/linux-java-version.png)

:::warning
Чтобы использовать большинство современных версий Minecraft, вам потребуется установить как минимум Java 17. Если эта команда отображает любую версию ниже 17, вам придётся обновить Java.
:::

## 2. Загрузка и установка Java 17

Мы рекомендуем использовать OpenJDK 17, который доступен для большинства дистрибутивов Linux.

### Arch Linux

:::info
Для дополнительной информации об установке Java в Arch Linux смотрите [википедию Arch Linux](https://wiki.archlinux.org/title/Java_(Русский)).
:::

Вы можете установить последнюю версию JRE из официальных репозиториев:

```sh
sudo pacman -S jre-openjdk
```

Если вы используете сервер без необходимости в графическом интерфейсе, вы можете вместо этого установить `headless` версию:

```sh
sudo pacman -S jre-openjdk-headless
```

Если вы планируете разрабатывать моды, вместо этого вам понадобится JDK:

```sh
sudo pacman -S jdk-openjdk
```

### Debian/Ubuntu

Вы можете установить Java 17, используя `apt`, с помощью следующих команд:

```sh
sudo apt update
sudo apt install openjdk-17-jdk
```

### Fedora

Вы можете установить Java 17, используя `dnf`, с помощью следующих команд:

```sh
sudo dnf install java-17-openjdk
```

Если вам не нужен графический интерфейс, вы можете вместо этого установить `headless` версию:

```sh
sudo dnf install java-17-openjdk-headless
```

Если вы планируете разрабатывать моды, вместо этого вам понадобится JDK:

```sh
sudo dnf install java-17-openjdk-devel
```

### Другие дистрибутивы Linux

Если вашего дистрибутива нет в списке выше, вы можете загрузить последнюю версию JRE с [Adoptium](https://adoptium.net/temurin/)

Вам следует обратиться к альтернативному гайду для вашего дистрибутива, если вы планируете разрабатывать моды.

## 3. Убедитесь, что Java 17 установлена

После того как установка закончится, вы можете проверить, что Java 17 установлена, открыв терминал и вписав `java -version`.

Если команда будет выполнена успешно, вы увидите что-то вроде показанного ранее, где отображается версия Java:

![Терминал с введённой командой "java -version"](/assets/players/installing-java/linux-java-version.png)
