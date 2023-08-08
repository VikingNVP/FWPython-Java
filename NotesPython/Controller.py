import Functions as func
import UsersInterface as ui

def run():
    case = ''
    while case != '7':
        ui.menu()
        case = input().strip()
        if case == '1':
            func.show('all')
        if case == '2':
            func.add()
        if case == '3':
            func.show('all')
            func.id_edit_del_show('del')
        if case == '4':
            func.show('all')
            func.id_edit_del_show('edit')
        if case == '5':
            func.show('date')
        if case == '6':
            func.show('id')
            func.id_edit_del_show('show')
        if case == '7':
            ui.goodbuy()
            break
