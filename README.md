# Trabajo Practico 2 - AlgoEmpires
[![Build Status](https://travis-ci.com/Franco-Giordano/AyP3-TP2-AlgoEmpires.svg?token=7zpnJJggDS7tTpxSzkvp&branch=master)](https://travis-ci.com/Franco-Giordano/AyP3-TP2-AlgoEmpires)
[![codecov](https://codecov.io/gh/Franco-Giordano/AyP3-TP2-AlgoEmpires/branch/master/graph/badge.svg?token=6KjVYytxIF)](https://codecov.io/gh/Franco-Giordano/AyP3-TP2-AlgoEmpires)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ffaaf84db0194c8ab284ace8c6695088)](https://www.codacy.com?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Franco-Giordano/AyP3-TP2-AlgoEmpires&amp;utm_campaign=Badge_Grade)

### Intro
Videojuego desarrollado en el marco del trabajo practico 2 de la materia Algoritmos y Programacion III (75.07 / 95.02), FIUBA 2018 segundo cuatrimestre.

### Enunciado
Ver el enunciado completo [aqui](https://docs.google.com/document/d/1OnD7ZRBIIZvv1snlR64WYj33abb-G3OODbTMaystsU8/edit)

### Entregas
**_Entrega 0 (8 de noviembre)_**
- [X] Repositorio con la estructura básica del proyecto con los scripts de Ant y la herramienta de integración contínua configurada. Se podrá utilizar el proyecto base provisto por la cátedra como referencia.
Solamente un miembro del grupo (cualquiera) deberá subir el enlace del repositorio mediante el botón “Agregar entrega” del campus virtual.

[**_Entrega 1 (Semana del 12 de noviembre)_**](https://github.com/Franco-Giordano/AyP3-TP2-AlgoEmpires/projects/1)
- [ ] Pruebas del Mapa
  - [ ] Tamaño
  - [ ] Colocar unidades y edificios
- [ ] Pruebas de unidades
  - [ ] Pruebas de movimiento y dirección (1 casillero por turno en las 8 posibles direcciones, siempre y cuando no intenten ir más allá del mapa)
    - [ ] aldeano
    - [ ] arquero
    - [ ] espadachín
    - [ ] arma de asedio
  - [ ] Pruebas de construcción
    - [ ] aldeano
      - [ ] verificar construcción de cuartel y plaza central
      - [ ] verificar que se haga en los turnos propios al jugador
      - [ ] verificar que no suma oro
  - [ ] Pruebas de reparación
    - [ ] aldeano
      - [ ] verificar reparación
      - [ ] verificar que se finalizada la reparación, sume oro
- [ ] Pruebas de edificios
    - [ ] Cuartel crea:
      - [ ] espadachín
      - [ ] arquero
    - [ ] Plaza central crea aldeano
    - [ ] castillo crea arma de asedio

**_Entrega 2 (Semana del 19 de noviembre)_**
- [ ] Distribución de los jugadores en el mapa
    - [ ] Pruebas de inicio del juego, posición, edificios, aldeanos y oro necesarios.
- [ ] Reglas de población
    - [ ] Crear unidades => sube la población
    - [ ] Matar unidades => baja población
    - [ ] Matar aldeanos => baja población y baja producción de oro
    - [ ] Verificar tope poblacional
- [ ] Pruebas de distancia y ataques (tanto para las unidades como para el castillo)

**_Entrega 3 (Semana del 26 de noviembre)_**
- [ ] Interfaz gráfica inicial básica: solicitud de jugador 1, jugador 2, comienzo de partida, disposición de jugadores en el tablero, botonera de acciones.
- [ ] Reglas de finalización de juego (modelo)

**_Entrega 4 - Final: (6 de diciembre)_**
- [ ] Trabajo Práctico completo funcionando, con interfaz gráfica final, sonidos e informe completo.
