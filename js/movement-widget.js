function canAdd(widgetSpace, rowSpaced) {
    return widgetSpace + rowSpaced <= 12;
}
function addToRow(widget, widgetsRows, direction) {
    let index;
    if (direction === 'UP') {
       index = widget.row - 1 
    } else {
        index = widget.row + 1
    }
    if (canAdd(widget.space, widgetsRows[index].spaced)) {
        // widgetsRow.widgets.splice(widget.index, 0, item);
    } else {
        // New row
        const row = { spaced: widget.space, widgets: [widget]};
        widgetsRows.splice(widget.row, 0, row)
    }
}